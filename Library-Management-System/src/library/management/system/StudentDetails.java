/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener{

    private JPanel bg;
    private JTable table;
    private JTextField search;
    private JButton b1,b2;
    
    public static void main(String[] args) {
	new StudentDetails().setVisible(true);
    }

    public void student() {
        try {
            conn con = new conn();
            String sql = "select * from student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public StudentDetails() {
        setBounds(100, 100, 890, 475);
           JLabel bg = new JLabel("");
         ImageIcon bi1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/bg.jpg"));
         Image bi3 = bi1.getImage().getScaledInstance(890, 475,Image.SCALE_DEFAULT);
         ImageIcon bi2 = new ImageIcon(bi3);
        bg = new JLabel(bi2);
        bg.setBounds(0, 0, 890, 475);
         setContentPane(bg);
       /* bg = new JPanel();
	bg.setBackground(new Color(220, 220, 220));
	bg.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(bg);
        bg.setBackground(Color.WHITE);
	bg.setLayout(null);*/

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(79, 133, 771, 288);
	bg.add(scrollPane);

	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
		search.setText(table.getModel().getValueAt(row, 1).toString());
            }
	});
	table.setBackground(new Color(240, 248, 255));
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);

	 b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
	b1.setForeground(Color.DARK_GRAY);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b1.setBounds(564, 89, 138, 33);
	bg.add(b1);

	 b2 = new JButton("Delete");
	b2.addActionListener(this);
	ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/nineth.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
	b2.setForeground(Color.DARK_GRAY);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	b2.setBounds(712, 89, 138, 33);
	bg.add(b2);

	JLabel l1 = new JLabel("Student Details");
	l1.setForeground(new Color(102, 205, 170));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
	l1.setBounds(250, 20, 400, 47);
	bg.add(l1);


	search = new JTextField();
	search.setBackground(new Color(255, 240, 245));
	search.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	search.setForeground(new Color(47, 79, 79));
	search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
	search.setBounds(189, 89, 357, 33);
	bg.add(search);
	search.setColumns(10);

	JLabel l2 = new JLabel("Back");
	l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Home home = new Home();
		home.setVisible(true);
            }
	});
	l2.setForeground(Color.GRAY);
	l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l2.setIcon(i9);
	l2.setBounds(97, 89, 72, 33);
	bg.add(l2);

	/*JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Student-Deatails",
		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 209, 204)));
	panel.setBounds(68, 59, 790, 370);
        panel.setBackground(Color.WHITE);
	bg.add(panel);*/
        
	student();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            conn con = new conn();
            if( ae.getSource() == b1){
                String sql = "select * from student where concat(name, student_id) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(rs));
		rs.close();
		st.close();
            }
    
            if(ae.getSource() == b2){
                String sql = "delete from student where name = '" + search.getText() + "'";
		PreparedStatement st = con.c.prepareStatement(sql);

		JDialog.setDefaultLookAndFeelDecorated(true);
		int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) {

		} else if (response == JOptionPane.YES_OPTION) {
                    int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted !!");
		} else if (response == JOptionPane.CLOSED_OPTION) {
                
                }
		st.close();
		
            }
            con.c.close();
        }catch(Exception e){
            
        }
    }
}
