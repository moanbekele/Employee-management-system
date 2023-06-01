package Employee;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




class remove_employee implements ActionListener {
    private JFrame frame2;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l55,l30,l20;
    private JButton b,b1,b2,b3;
    private String emp_id;
    remove_employee(String fn, String ln, String phone, String email, String emp_id){
        this.emp_id= emp_id;
        frame2 = new JFrame("Remove Employee");
        frame2.setBackground(Color.green);
        frame2.setLayout(null);

        l55 = new JLabel();
        l55.setBounds(0, 0, 500, 500);
        l55.setLayout(null);
        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("icon/remove.jpg"));
        l55.setIcon(img2);
        frame2.add(l55);

        l2=new JLabel("First Name:");
        l2.setBounds(50,100,250,30);
        l2.setForeground(Color.white);
        Font f3 = new Font("serif",Font.BOLD,20);
        l2.setFont(f3);
        l55.add(l2);

        l6=new JLabel(fn);
        l6.setBounds(200,100,350,30);
        l6.setForeground(Color.white);
        Font F6=new Font("serif",Font.BOLD,20);
        l6.setFont(F6);
        l55.add(l6);

        l3=new JLabel("Last Name:");
        l3.setBounds(50,150,250,30);
        l3.setForeground(Color.white);
        Font f4 = new Font("serif",Font.BOLD,20);
        l3.setFont(f4);
        l55.add(l3);


        l7=new JLabel(ln);
        l7.setBounds(200,150,350,30);
        l7.setForeground(Color.white);
        Font F7=new Font("serif",Font.BOLD,20);
        l7.setFont(F7);
        l55.add(l7);



        l4=new JLabel("Mobile No:");
        l4.setBounds(50,200,250,30);
        l4.setForeground(Color.white);
        Font F5=new Font("serif",Font.BOLD,20);
        l4.setFont(F5);
        l55.add(l4);

        l8=new JLabel(phone);
        l8.setBounds(200,200,350,30);
        l8.setForeground(Color.white);
        Font f8=new Font("serif",Font.BOLD,20);
        l8.setFont(f8);
        l55.add(l8);



        l20=new JLabel("Email Id:");
        l20.setBounds(50,250,250,30);
        l20.setForeground(Color.white);
        Font F50=new Font("serif",Font.BOLD,20);
        l20.setFont(F5);
        l55.add(l20);

        l30=new JLabel(email);
        l30.setBounds(200,250,350,30);
        l30.setForeground(Color.white);
        Font f80=new Font("serif",Font.BOLD,20);
        l30.setFont(f8);
        l55.add(l30);

        b1=new JButton("Remove");
        b1.setBounds(120,350,100,30);
        b1.addActionListener(this);
        l55.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(300,350,100,30);
        b2.addActionListener(this);
        l55.add(b2);
        frame2.add(l55);

        frame2.setSize(500,500);
        frame2.setLocation(500,250);
        frame2.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {conn con = new conn();
                String str = "delete from employee where emp_id = '"+emp_id+"'";
                con.st.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"deleted successfully");
                frame2.setVisible(false);
                new main_window();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Exception occurred while deleting record "+ex);
            }

        }
        if(ae.getSource()==b2){
            frame2.setVisible(false);
            new search_to_remove();
        }

    }


    public static void main(String[] args){
        new remove_employee("", "", "", "", "");
    }


}
