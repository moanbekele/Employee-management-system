package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class add_employee implements ActionListener {

	JFrame frame;
    JLabel box,title,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b1,b2;

    
    add_employee(){
        frame = new JFrame("Add Employee");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        box = new JLabel();
        box.setBounds(0,0,900,700);
        box.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/add.jpg"));
        box.setIcon(img);

        title = new JLabel("New Employee Details");
        title.setBounds(320,30,500,50);
        title.setFont(new Font("serif",Font.ITALIC,25));
        title.setForeground(Color.black);
        box.add(title);
        frame.add(box);

 
        label1 = new JLabel("First Name");
        label1.setBounds(50,150,100,30);
        label1.setFont(new Font("serif",Font.BOLD,20));
        box.add(label1);

        t1=new JTextField();
        t1.setFont(new Font("serif",Font.BOLD,15));
        t1.setBounds(200,150,150,30);
        box.add(t1);

        label2 = new JLabel("Last Name");
        label2.setBounds(400,150,200,30);
        label2.setFont(new Font("serif",Font.BOLD,20));
        box.add(label2);

        t2=new JTextField();
        t2.setFont(new Font("serif",Font.BOLD,15));
        t2.setBounds(600,150,150,30);
        box.add(t2);



        label4 = new JLabel("Date Of Birth");  
        label4.setBounds(50,200,200,30);
        label4.setFont(new Font("serif",Font.BOLD,20));
        box.add(label4);

        t4=new JTextField();
        t4.setFont(new Font("serif",Font.BOLD,15));
        t4.setBounds(200,200,150,30);
        box.add(t4);

        label5 = new JLabel("Address");
        label5.setBounds(400,200,100,30);
        label5.setFont(new Font("serif",Font.BOLD,20));
        box.add(label5);

        t5=new JTextField();
        t5.setFont(new Font("serif",Font.BOLD,15));
        t5.setBounds(600,200,150,30);
        box.add(t5);

        label6 = new JLabel("Phone");
        label6.setBounds(50,250,100,30);
        label6.setFont(new Font("serif",Font.BOLD,20));
        box.add(label6);

        t6=new JTextField();
        t6.setFont(new Font("serif",Font.BOLD,15));
        t6.setBounds(200,250,150,30);
        box.add(t6);

        label7 = new JLabel("Email Id");
        label7.setBounds(400,250,100,30);
        label7.setFont(new Font("serif",Font.BOLD,20));
        box.add(label7);

        t7=new JTextField();
        t7.setFont(new Font("serif",Font.BOLD,15));
        t7.setBounds(600,250,150,30);
        box.add(t7);

        label8 = new JLabel("Education");
        label8.setBounds(50,300,100,30);
        label8.setFont(new Font("serif",Font.BOLD,20));    
        box.add(label8);

        t8=new JTextField();
        t8.setFont(new Font("serif",Font.BOLD,15));
        t8.setBounds(200,300,150,30);
        box.add(t8);

        label9 = new JLabel("Job Post");
        label9.setBounds(400,300,100,30);
        label9.setFont(new Font("serif",Font.BOLD,20));
        box.add(label9);

        t9=new JTextField();
        t9.setFont(new Font("serif",Font.BOLD,15));
        t9.setBounds(600,300,150,30);
        box.add(t9);



        label11 = new JLabel("Employee Id");
        label11.setBounds(50,350,150,30);
        label11.setFont(new Font("serif",Font.BOLD,20));
        box.add(label11);

        t11=new JTextField();   
        t11.setFont(new Font("serif",Font.BOLD,15));
        t11.setBounds(200,350,150,30);
        box.add(t11);




        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250,480,150,40);
        box.add(b1);

        b2=new JButton("Cancel");   
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(450,480,150,40);
        box.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(200,20);
    }


	
    
    @Override
	public void actionPerformed(ActionEvent ae) {
	
		String a  = t1.getText();
        String bb = t2.getText();
        String c  = t4.getText();
        String dd  = t5.getText();
        String e = t6.getText();
        String ff  = t7.getText();
        String g  = t8.getText();
        String hh  = t9.getText();
        String i  = t11.getText();
        if(ae.getSource() == b1){
            try{
                if(a.equals("")||bb.equals("")||i.equals("")){
                    JOptionPane.showMessageDialog(null,"You left out essential components empty");
                }
                else{
                    conn cc = new conn();
                    String q = "insert into employee values('"+a+"','"+bb+"','"+c+"','"+dd+"','"+e+"','"+ff+"','"+g+"','"+hh+"','"+i+"')";
                    cc.st.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                    frame.setVisible(false); // close current frame.
                    new main_window(); // open details page
                }

            }catch(Exception ee){
                System.out.println("The error is:"+ee);
                JOptionPane.showMessageDialog(null,"An Error has occurred, check terminal for details");

            }
        }else if(ae.getSource() == b2){
            frame.setVisible(false);
            new main_window();
        }else if(ae.getSource() == b2){
            frame.setVisible(false);
            new main_window();
        }
		
		
	}
	
	

	public static void main(String[] args) {
		new add_employee();
	}
	 
	
}
