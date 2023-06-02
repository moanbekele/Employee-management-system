package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class search_to_view implements ActionListener{

    JFrame frame;
    JTextField t;
    JLabel l1,l2;
    JButton b1,b2;

    search_to_view(){
        frame=new JFrame("Locate Employee");
        frame.setBackground(Color.green);
        frame.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icon/view.jpg"));
        l1.setIcon(img);


        l2=new JLabel("Employee Id");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.white);
        Font F1 = new Font("serif",Font.BOLD,30);
        l2.setFont(F1); 
        l1.add(l2);
        frame.add(l1);


        t=new JTextField();
        t.setFont(new Font("serif",Font.BOLD,17));
        t.setBounds(240,60,220,30);
        l1.add(t);

        b1=new JButton("Search");
        b1.setBounds(240,150,100,30);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l1.add(b2);

        frame.setSize(500,270);
        frame.setLocation(450,250);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            frame.setVisible(false);
            main_window d=new main_window();
        }
        if(ae.getSource()==b1){
            frame.setVisible(false);
            print_data p=new print_data(t.getText());
        }

    }

    public static void main(String[]ar){
        search_to_view v = new search_to_view();
    }
}