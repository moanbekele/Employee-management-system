package Employee;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class search_to_remove implements ActionListener{
    private JFrame frame;
    private JTextField t;
    private JLabel l1,l5;
    private JButton b,b3;
    private String fname,lname,phone,email;

    search_to_remove() {
        frame = new JFrame("Remove Employee");
        frame.setBackground(Color.green);
        frame.setLayout(null);

        l5 = new JLabel();
        l5.setBounds(0, 0, 500, 500);
        l5.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/remove.jpg"));
        l5.setIcon(img);
        frame.add(l5);


        l1 = new JLabel("Employee Id");
        l1.setBounds(50, 50, 250, 30);
        l1.setForeground(Color.white);
        Font f2 = new Font("serif", Font.BOLD, 25);
        l1.setFont(f2);
        l5.add(l1);

        t = new JTextField();
        t.setBounds(250, 50, 150, 30);
        l5.add(t);


        b = new JButton("Display");
        b.setBounds(200, 100, 100, 30);
        b.addActionListener(this);
        l5.add(b);

        b3 = new JButton("Back");
        b3.setBounds(360, 100, 100, 30);
        b3.addActionListener(this);
        l5.add(b3);
        frame.setSize(500, 500);
        frame.setLocation(500, 250);
        frame.setVisible(true);


    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            try {
                conn con = new conn();
                String str = "select FirstName,LastName,PhoneNumber,Email from employee where emp_id ='" + t.getText() + "' ";
                ResultSet rs = con.st.executeQuery(str);

                int i = 0;
                while (rs.next()) {
                    fname = rs.getString(1); // col no. 1
                    lname = rs.getString(2); // col no. 2
                    phone = rs.getString(3); // col no. 3
                    email = rs.getString(4); // col no. 3
                    i++;
                }
                if (i == 0) {
                    JOptionPane.showMessageDialog(null, "Id not found");
                }
                else{
                    frame.setVisible(false);
                    remove_employee cr = new remove_employee(fname,lname,phone,email,t.getText());
                }
            }catch(Exception ex){}


        }
        

        if(ae.getSource()==b3){
            frame.setVisible(false);
            main_window d=new main_window();
        }
    }

    
    
    public static void main(String[] args){
        new search_to_remove();
    }
}