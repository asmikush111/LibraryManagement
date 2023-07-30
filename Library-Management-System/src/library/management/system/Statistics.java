package library.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Statistics extends JFrame{

    private JPanel bg;
    private JTable table;
    private JTable table_1;

    public static void main(String[] args) {
        new Statistics().setVisible(true);
    }

    public void issueBook() {
	try {
            conn con =  new conn();
            String sql = "select * from issueBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

	} catch (Exception e) {
			// TODO: handle exception
	}
    }

    public void returnBook() {
        try {
            conn con = new conn();
            String sql = "select * from returnBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
	} catch (Exception e) {
			// TODO: handle exception
	}
    }

    public Statistics() {
        setBounds(100, 100, 810, 594);
           JLabel bg = new JLabel("");
         ImageIcon bi1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/bg.jpg"));
         Image bi3 = bi1.getImage().getScaledInstance(810, 594,Image.SCALE_DEFAULT);
         ImageIcon bi2 = new ImageIcon(bi3);
        bg = new JLabel(bi2);
        bg.setBounds(0, 0, 810, 594);
         setContentPane(bg);
	/*bg = new JPanel();
        bg.setBackground(Color.WHITE);
	bg.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(bg);
	bg.setLayout(null);*/

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(40, 51, 708, 217);
	bg.add(scrollPane);

        table = new JTable();
	table.setBackground(new Color(224, 255, 255));
	table.setForeground(new Color(128, 128, 0));
	table.setFont(new Font("Sitka Small", Font.BOLD, 12));
	scrollPane.setViewportView(table);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 2, true), "Issue-Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
	panel.setForeground(new Color(0, 128, 128));
	panel.setBounds(26, 36, 737, 240);
        panel.setBackground(Color.WHITE);
	bg.add(panel);

	JLabel l1 = new JLabel("Back");
	l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
		setVisible(false);
		Home home = new Home();
		home.setVisible(true);
            }
	});
	l1.setForeground(new Color(204, 0, 102));
	l1.setFont(new Font("Tahoma", Font.BOLD, 18));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
	l1.setBounds(690, 13, 96, 27);
	bg.add(l1);

	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(40, 316, 717, 217);
	bg.add(scrollPane_1);

	table_1 = new JTable();
	table_1.setBackground(new Color(204, 255, 255));
	table_1.setForeground(new Color(153, 51, 0));
	table_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
	scrollPane_1.setViewportView(table_1);

	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 2, true), "Return-Book-Details",
		TitledBorder.LEFT, TitledBorder.TOP, null, Color.DARK_GRAY));
	panel_1.setBounds(22, 299, 741, 240);
        panel_1.setBackground(Color.WHITE);
	bg.add(panel_1);
        

	issueBook();
	returnBook();
    }
}
