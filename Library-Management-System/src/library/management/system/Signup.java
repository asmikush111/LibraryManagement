/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel bg;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(100, 100, 606, 406);
        JLabel bg = new JLabel("");
         ImageIcon bi1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/director.jpeg"));
         Image bi3 = bi1.getImage().getScaledInstance(650, 500,Image.SCALE_DEFAULT);
         ImageIcon bi2 = new ImageIcon(bi3);
        bg = new JLabel(bi2);
        bg.setBounds(0, 0, 650, 500);
       setContentPane(bg);
	/*bg = new JPanel();
	bg.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(bg);
        bg.setBackground(Color.WHITE);
	bg.setLayout(null);*/

	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.DARK_GRAY);
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblUsername.setBounds(99, 86, 120, 26);
	bg.add(lblUsername);

	JLabel lblName = new JLabel("Name :");
	lblName.setForeground(Color.DARK_GRAY);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblName.setBounds(99, 123, 92, 26);
	bg.add(lblName);

	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setForeground(Color.DARK_GRAY);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblPassword.setBounds(99, 160, 120, 26);
	bg.add(lblPassword);

	JLabel lblAnswer = new JLabel("Answer :");
	lblAnswer.setForeground(Color.DARK_GRAY);
	lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblAnswer.setBounds(99, 234, 92, 26);
	bg.add(lblAnswer);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your child SuperHero?", "Your childhood Name ?" }));
	comboBox.setBounds(265, 202, 148, 20);
	bg.add(comboBox);

	JLabel lblSecurityQuestion = new JLabel("Security Question:");
	lblSecurityQuestion.setForeground(Color.DARK_GRAY);
	lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblSecurityQuestion.setBounds(99, 197, 160, 26);
	bg.add(lblSecurityQuestion);

        textField = new JTextField();
	textField.setBounds(265, 91, 148, 20);
	bg.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(265, 128, 148, 20);
	bg.add(textField_1);

        textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(265, 165, 148, 20);
	bg.add(textField_2);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(265, 239, 148, 20);
	bg.add(textField_3);

	b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 17));
	b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	bg.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 17));
	b2.setBounds(300, 289, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	bg.add(b2);

	/*JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	panel.setBounds(31, 46, 476, 296);
        panel.setBackground(Color.WHITE);
	bg.add(panel);*/
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            
            if(ae.getSource() == b1){
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
		st.setString(3, textField_2.getText());
		st.setString(4, (String) comboBox.getSelectedItem());
		st.setString(5, textField_3.getText());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                textField.setText("");
                textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Login_user().setVisible(true);
			
            }
        }catch(Exception e){
            System.out.println(e);
           
        }
    }
}

