package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class update_employee  implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3; 
    String id_emp;

    update_employee(String idaa){
        
        f=new JFrame("update Employee details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);

        id_emp=idaa;    
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        id15.setIcon(img);
        f.add(id15);

        id8 = new JLabel("Update Employee Detail:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("First Name:");
        id1.setBounds(50,100,140,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        id15.add(t1);

        id2 = new JLabel("Last Name:");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);

        id3= new JLabel("DOB:");
        id3.setBounds(50,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        id15.add(t3);

        id4= new JLabel("Address:");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        id15.add(t4);

        id5= new JLabel("Phone Number:");
        id5.setBounds(50,200,140,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        id15.add(t5);

        id6= new JLabel("Email:");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        id15.add(t6);

        id7= new JLabel("Education");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        id15.add(t7);

        id9= new JLabel("Position");
        id9.setBounds(400,250,100,30);  
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);
        f.setVisible(false);
        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        id15.add(t8);


        b=new JButton("update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        id15.add(b1);

        try{
            conn con = new conn();
            String str = "select * from employee where emp_id = '"+id_emp+"'";
            ResultSet rs = con.st.executeQuery(str); // whole row stored in rs
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(3));
            t4.setText(rs.getString(4));
            t5.setText(rs.getString(5));
            t6.setText(rs.getString(6));
            t7.setText(rs.getString(7));
            t8.setText(rs.getString(8));

        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("fuck you");

        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){ //clicking on the update button
            try{
                conn con = new conn();
                String str = "update employee set FirstName='"+t1.getText()+"',LastName='"+t2.getText()+"',Dob='"+t3.getText()+"',Address='"+t4.getText()+"',PhoneNumber='"+t5.getText()+"',Email='"+t6.getText()+"',Education='"+t7.getText()+"' where emp_id='"+id_emp+"'";
                con.st.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Successfully updated");
                f.setVisible(false);
                new main_window();
            }catch(Exception e){
                System.out.println("The error is:"+e);
                JOptionPane.showMessageDialog(null,"An Error has occurred, check terminal for details");
            }
        }
        if(ae.getSource()==b1){ //Clicking on cancel
            f.setVisible(false);
            search_to_update se =new search_to_update();
        }
    }

    
    public static void main(String[] arg){
        new update_employee("");
    }
    
}