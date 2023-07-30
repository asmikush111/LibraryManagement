package library.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

	//private JPanel contentPane;
        private JButton b1,b2,b3,b4,b5,b6,b7,b8;

	public static void main(String[] args) {
            new Home().setVisible(true);
	}
        
        public Home() {
	    
            setBounds(100, 20, 1000, 800);
             JLabel bg = new JLabel("");
                  
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/bg.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1000, 800,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                bg = new JLabel(i2);
                bg.setBounds(0, 0, 1000, 800);
                //add(bg);
                setContentPane(bg);
            //contentPane = new JPanel();
            //setContentPane(contentPane);
            //contentPane.setLayout(null);

            
            JMenuBar menuBar = new JMenuBar();
           // menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
            menuBar.setBackground(Color.LIGHT_GRAY);
            menuBar.setBounds(0, 10, 1000, 40);
            bg.add(menuBar);

            JMenu mnExit = new JMenu("Exit");
            mnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
            
            
            JMenuItem mntmLogout = new JMenuItem("Logout");
            mntmLogout.setBackground(new Color(211, 211, 211));
            mntmLogout.setForeground(new Color(105, 105, 105));
            mntmLogout.addActionListener(this);
            mnExit.add(mntmLogout);
            
            JMenuItem mntmExit = new JMenuItem("Exit");
            mntmExit.setForeground(new Color(105, 105, 105));
            mntmExit.setBackground(new Color(211, 211, 211));
            mntmExit.addActionListener(this);
            mnExit.add(mntmExit);
                
            

            JMenu mnHelp = new JMenu("Help");
            mnHelp.setFont(new Font("Tahoma", Font.BOLD, 17));
            

            JMenuItem mntmReadme = new JMenuItem("Read Me");
            mntmReadme.setBackground(new Color(211, 211, 211));
            mntmReadme.setForeground(new Color(105, 105, 105));
            mnHelp.add(mntmReadme);

            JMenuItem mntmAboutUs = new JMenuItem("About Us");
            mntmAboutUs.setForeground(new Color(105, 105, 105));
            mntmAboutUs.setBackground(new Color(211, 211, 211));
            mntmAboutUs.addActionListener(this);
            mnHelp.add(mntmAboutUs);

            JMenu mnRecord = new JMenu("Details");
            mnRecord.setFont(new Font("Tahoma", Font.BOLD, 17));
            

            JMenuItem bookdetails = new JMenuItem("Book Details");
            bookdetails.addActionListener(this);
            bookdetails.setBackground(new Color(211, 211, 211));
            bookdetails.setForeground(Color.DARK_GRAY);
            mnRecord.add(bookdetails);

            JMenuItem studentdetails = new JMenuItem("Student Details");
            studentdetails.setBackground(new Color(211, 211, 211));
            studentdetails.setForeground(Color.DARK_GRAY);
            studentdetails.addActionListener(this);
            mnRecord.add(studentdetails);
            
            menuBar.add(mnRecord);
            menuBar.add(mnHelp);
            menuBar.add(mnExit);

            
            JLabel l1 = new JLabel("Library Management System");
            l1.setForeground(Color.blue);
            l1.setFont(new Font("Tahoma", Font.BOLD, 30));
            l1.setBounds(268, 50, 701, 80);
            bg.add(l1);

            JLabel l2 = new JLabel("");
            l2.setVerticalAlignment(SwingConstants.TOP);
            ImageIcon bi1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/second.png"));
            Image bi2 = bi1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon bi3 = new ImageIcon(bi2);
            l2 = new JLabel(bi3);
            l2.setBounds(60, 140, 159, 152);
            bg.add(l2);

            JLabel l3 = new JLabel("");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/third.png"));
            Image i5 = i4.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            l3 = new JLabel(i6);
            l3.setBounds(560, 160, 134, 128);
            bg.add(l3);

            JLabel l4 = new JLabel("");
            ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fourth.png"));
            Image i8 = i7.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            l4 = new JLabel(i9);
            l4.setBounds(300, 140, 225, 152);
            bg.add(l4);
             
            JLabel l8 = new JLabel("");
            ImageIcon i19  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fourth.png"));
            Image i20 = i19.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i21 = new ImageIcon(i8);
            l8 = new JLabel(i9);
            l8.setBounds(720, 140, 225, 152);
            bg.add(l8);
            
            b1 = new JButton("Add Books");
            b1.addActionListener(this);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
            b1.setBounds(60, 320, 159, 44);
            bg.add(b1);

            b2 = new JButton("Statistics");
            b2.addActionListener(this);
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            b2.setFont(new Font("Tahoma", Font.PLAIN, 20));
            b2.setBounds(562, 320, 139, 44);
            bg.add(b2);

            b3 = new JButton("Add Student");
            b3.addActionListener(this);
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.WHITE);
            b3.setFont(new Font("Tahoma", Font.PLAIN, 20));
            b3.setBounds(313, 320, 167, 44);
            bg.add(b3);

            b7 = new JButton("Show Student");
            b7.addActionListener(this);
            b7.setBackground(Color.BLACK);
            b7.setForeground(Color.WHITE);
            b7.setFont(new Font("Tahoma", Font.PLAIN, 20));
            b7.setBounds(750, 320, 167, 44);
            bg.add(b7);
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2), "Operation", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.LIGHT_GRAY));
            panel.setBounds(20, 120, 930, 260);
            panel.setOpaque(false);
            bg.add(panel);

            b4 = new JButton("Issue Book");
            b4.addActionListener(this);
            b4.setBackground(Color.BLACK);
            b4.setForeground(Color.WHITE);
            b4.setFont(new Font("Tahoma", Font.PLAIN, 20));
            b4.setBounds(76, 620, 143, 41);
            bg.add(b4);

            b5 = new JButton("Return Book");
            b5.addActionListener(this);
            b5.setBackground(Color.BLACK);
            b5.setForeground(Color.WHITE);
            b5.setFont(new Font("Tahoma", Font.PLAIN, 20));
            b5.setBounds(310, 620, 159, 41);
            bg.add(b5);

            b6 = new JButton("About Us");
            b6.addActionListener(this);
            b6.setBackground(Color.BLACK);
            b6.setForeground(Color.WHITE);
            b6.setFont(new Font("Tahoma", Font.PLAIN, 20));
            b6.setBounds(562, 620, 159, 41);
            bg.add(b6);
             b8 = new JButton("Show Books");
            b8.addActionListener(this);
            b8.setBackground(Color.BLACK);
            b8.setForeground(Color.WHITE);
            b8.setFont(new Font("Tahoma", Font.PLAIN, 20));
            b8.setBounds(750, 620, 159, 41);
            bg.add(b8);

            JLabel l5 = new JLabel("");
            ImageIcon i10  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fifth.png"));
            Image i11 = i10.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i12 = new ImageIcon(i11);
            l5 = new JLabel(i12);
            l5.setBounds(60, 440, 159, 163);
            bg.add(l5);

            JLabel l6 = new JLabel("");
            ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/sixth.png"));
            Image i14 = i13.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i15 = new ImageIcon(i14);
            l6 = new JLabel(i15);
            l6.setBounds(332, 440, 139, 152);
            bg.add(l6);

            JLabel l7 = new JLabel("");
            ImageIcon i16  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/seventh.png"));
            Image i17 = i16.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i18 = new ImageIcon(i17);
            l7 = new JLabel(i18);
            l7.setBounds(562, 440, 157, 152);
            bg.add(l7);

             JLabel l9 = new JLabel("");
            ImageIcon i22  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fifth.png"));
            Image i23 = i22.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i24 = new ImageIcon(i23);
            l9 = new JLabel(i24);
            l9.setBounds(750, 440, 157, 152);
            bg.add(l9);
            
            JPanel panel2 = new JPanel();
            panel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2), "Action", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.LIGHT_GRAY));
            panel2.setBounds(20, 420, 930, 270);
             panel2.setOpaque(false);
            bg.add(panel2);
            
            //getContentPane().setBackground(Color.WHITE);
           // bg.setBackground(Color.WHITE);
	}
        
        
        public void actionPerformed(ActionEvent ae){
            String msg = ae.getActionCommand();
            if(msg.equals("Logout")){
                setVisible(false);
		new Login_user().setVisible(true);
            }else if(msg.equals("Exit")){
                System.exit(ABORT);
            
            }else if(msg.equals("Read Me")){
            
            }else if(msg.equals("About Us")){
                setVisible(false);
		new aboutUs().setVisible(true);
            
            }else if(msg.equals("Book Details")){
                setVisible(false);
		new BookDetails().setVisible(true);
            }else if(msg.equals("Student Details")){
                setVisible(false);
                new StudentDetails().setVisible(true);
			
            }
            
            if(ae.getSource() == b1){
                this.setVisible(false);
                new AddBook().setVisible(true);
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Statistics().setVisible(true);
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new AddStudent().setVisible(true);
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new IssueBook().setVisible(true);
            }
            if(ae.getSource() == b5){
                this.setVisible(false);
                new ReturnBook().setVisible(true);
            
            }
            if(ae.getSource() == b6){
                this.setVisible(false);
                new aboutUs().setVisible(true);
            
            }
            if(ae.getSource() == b7){
                this.setVisible(false);
                new StudentDetails().setVisible(true);
            
            }
             if(ae.getSource() == b8){
                this.setVisible(false);
                new BookDetails().setVisible(true);
            
            }
            
        }
}
