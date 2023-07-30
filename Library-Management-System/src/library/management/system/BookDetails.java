package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class BookDetails extends JFrame implements ActionListener{

    private JPanel bg;
    private JTable table;
    private JTextField search;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
	new BookDetails().setVisible(true);
    }
    
    public void Book() {
	try {
            conn con = new conn();
            String sql = "select * from book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
	} catch (Exception e) {
	
	}
    }

    public BookDetails() {
        setBounds(100, 100, 890, 475);
           JLabel bg = new JLabel("");
         ImageIcon bi1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/bg.jpg"));
         Image bi3 = bi1.getImage().getScaledInstance(890, 475,Image.SCALE_DEFAULT);
         ImageIcon bi2 = new ImageIcon(bi3);
        bg = new JLabel(bi2);
        bg.setBounds(0, 0, 890, 475);
         setContentPane(bg);
        /*bg = new JPanel();
        bg.setBackground(Color.WHITE);
        bg.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(bg);
	bg.setLayout(null);*/

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(79, 133, 771, 282);
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
	
	b1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
	b1.setForeground(Color.DARK_GRAY);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b1.setBounds(564, 89, 138, 33);
	bg.add(b1);
        b1.addActionListener(this);
        b2 = new JButton("Delete");
	
	ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/nineth.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
        b2.setForeground( Color.DARK_GRAY);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
	b2.setBounds(712, 89, 138, 33);
	bg.add(b2);
        b2.addActionListener(this);

	JLabel l1 = new JLabel("Book Details");
	l1.setForeground(Color.BLACK);
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
	l1.setBounds(300, 15, 400, 47);
	bg.add(l1);

        
	search = new JTextField();
	search.setBackground(new Color(255, 240, 245));
	search.setBorder(new LineBorder( Color.LIGHT_GRAY, 2, true));
	search.setForeground(new Color(47, 79, 79));
	search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
	search.setBounds(189, 89, 357, 33);
	bg.add(search);
	search.setColumns(10);

	JLabel l3 = new JLabel("Back");
	l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
	l3.setForeground(Color.GRAY);
	l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l3.setIcon(i9);
	l3.setBounds(97, 89, 72, 33);
	bg.add(l3);

	/*JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true), "Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null,Color.LIGHT_GRAY));
	panel.setBounds(67, 54, 793, 368);
	bg.add(panel);
        panel.setBackground(Color.WHITE);*/
	Book();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            conn con = new conn(); 
            if(ae.getSource() == b1){
                
                String sql = "select * from book where concat(name, book_id) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();

            }
            if(ae.getSource() == b2){
                String sql = "delete from book where name = '" + search.getText() + "'";
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
