package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public LibraryManagementSystem() {
		
                setSize(1266,390);
                setLayout(null);
                setLocation(20,100);

		
                b1 = new JButton("Next");      
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);  
                
                b1.setBounds(1050,250,150,40);
                b1.setBackground(Color.LIGHT_GRAY);
                l1 = new JLabel("");
                  
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/first.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1266, 390,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                l1.setBounds(0, 0, 1266, 390);
                add(l1);
                
                
                l1.add(b1);
		
                
                
		
                b1.addActionListener(this);
	}
        
      
        public void actionPerformed(ActionEvent ae){
                new Login_user().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                LibraryManagementSystem window = new LibraryManagementSystem();
                window.setVisible(true);			
	}
}
