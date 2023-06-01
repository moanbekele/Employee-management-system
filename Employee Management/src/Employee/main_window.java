package Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class main_window implements ActionListener {

	JFrame frame;
	JLabel l1, l2;
	JButton b1, b2, b3, b4;
	
	
	main_window(){
	
		frame = new JFrame("Employee Dashboard");
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);


		
		l1 = new JLabel();
		l1.setBounds(0,0,700,500);
		l1.setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
		l1.setIcon(i1);
		frame.add(l1);
		
		
		
		l2 = new JLabel("Employee Details");
		l2.setBounds(430,20,200,40);
		l2.setFont(new Font("serif",Font.BOLD,25));
		l2.setForeground(Color.BLUE);
		l2.setLayout(null);
		frame.add(l2);
		
		
		
		
		b1 = new JButton("Add");
		b1.setBounds(420,80,90,30);
		b1.setBackground(Color.pink);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		
		
		b2 = new JButton("View");
		b2.setBounds(540,80,90,30);
		b2.setBackground(Color.pink);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(this);  // perform action on button click.
		frame.add(b2);
		
		
		b3 = new JButton("Remove");
		b3.setBounds(420,140,90,30);
		b3.setBackground(Color.pink);
		b1.setForeground(Color.black);
		b3.setFont(new Font("serif",Font.BOLD,15));
		b3.addActionListener(this);  // perform action on button click.
		frame.add(b3);
		
	
		
		b4 = new JButton("Update");
		b4.setBounds(540,140,90,30);
		b4.setBackground(Color.pink);
		b1.setForeground(Color.black);
		b4.setFont(new Font("serif",Font.BOLD,15));
		b4.addActionListener(this);  // perform action on button click.
		frame.add(b4);


		frame.setVisible(true);
		frame.setSize(700,500);
		frame.setLocation(450,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			frame.setVisible(false);
			new add_employee();
		}
		else if(e.getSource() == b2) {
			frame.setVisible(false);
			new search_to_view();
		}
		else if(e.getSource() == b3) {
			frame.setVisible(false);
			new search_to_remove();
		}
		else if(e.getSource() == b4) {
			frame.setVisible(false);
			new search_to_update();
		}
		
	}
	
	
	public static void main(String [] args) {
		main_window det = new main_window();
	}
	
}
