package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;


	public Login_user() {
            
	//setBackground(new Color(169, 169, 169));	
        setBounds(100, 100, 600, 400);
        setLayout(null);
	 JLabel bg = new JLabel("");
                  
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/director.jpeg"));
                Image i3 = i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                bg = new JLabel(i2);
                bg.setBounds(0, 0, 600, 400);
                //add(bg);
                setContentPane(bg);
       // panel = new JPanel();
	//panel.setBackground(Color.WHITE);
	//bg.add(panel);
	

	JLabel l1 = new JLabel("Username : ");
        l1.setForeground(Color.DARK_GRAY);
	l1.setFont(new Font("Tahoma", Font.BOLD, 20));
	l1.setBounds(124, 89, 130, 24);
	bg.add(l1);

	JLabel l2 = new JLabel("Password : ");
        l2.setForeground(Color.DARK_GRAY);
	l2.setFont(new Font("Tahoma", Font.BOLD, 20));
	l2.setBounds(124, 124, 130, 24);
	bg.add(l2);

	textField = new JTextField();
	textField.setBounds(250, 93, 200, 20);
	bg.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(250, 128, 200, 20);
	bg.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	bg.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
        bg.add(l3);

	b1 = new JButton("Login");
	b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 20));      
	b1.setForeground(Color.WHITE);
	b1.setBackground(Color.BLACK);
	b1.setBounds(149, 181, 113, 39);
	bg.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	 b2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	b2.setForeground(Color.WHITE);
	b2.setBackground(Color.BLACK);
	b2.setBounds(289, 181, 113, 39);
	bg.add(b2);

	b3 = new JButton("Forget");
	b3.addActionListener(this);
	b3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b3.setBackground(Color.WHITE);
	b3.setBounds(199, 251, 150, 39);
	bg.add(b3);

	JLabel l5 = new JLabel("Forget Password?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(Color.BLACK);
	l5.setBounds(70, 260, 130, 20);
	bg.add(l5);

		//JPanel panel2 = new JPanel();
		//panel2.setBackground(new Color(176, 224, 230));
		//panel2.setBounds(24, 40, 434, 263);
		//bg.add(panel2);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    conn con = new conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading().setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		Forgot forgot = new Forgot();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login_user().setVisible(true);
	}

}
