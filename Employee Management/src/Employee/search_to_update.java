package Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

// THIS CODE inherits from search_to_view page

class search_to_update extends search_to_view {


    search_to_update(){
        super();

    }

    
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            try {
                conn con = new conn();
                String str = "select * from employee where emp_id = '" + t.getText() + "'";
                ResultSet rs = con.st.executeQuery(str);

                if (rs.next()) { //Checking where Employee Id is stored in database or not
                    frame.setVisible(false);
                    String eid = t.getText();
                    update_employee p = new update_employee(eid);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Id not found");
                }

            }catch(Exception ex){}
        }
        if(ae.getSource()==b2){
            frame.setVisible(false);
            main_window d=new main_window();
        }


        }


    public static void main(String[]ar){
        search_to_update v=new search_to_update();
    }
}