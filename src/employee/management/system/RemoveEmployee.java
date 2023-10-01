
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee  extends JFrame implements ActionListener{
        Choice cEmpId;
        JButton delete,back;

        RemoveEmployee(){
           
                getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    
        JLabel labelempId = new  JLabel("Employee Id");
        labelempId.setBounds(560,275,100,30);
        add(labelempId); 
                  
        cEmpId = new Choice();
        cEmpId.setBounds(660,280,150,30);
        add(cEmpId);
        try{ 
              Conn c = new Conn();
              String query = " select * from employee ";
              ResultSet rs = c.s.executeQuery(query);
              while(rs.next()){
                   cEmpId.add(rs.getString("empId"));
              
              }

           } catch(Exception e){
             e.printStackTrace();
        }
        
        JLabel labelname = new  JLabel("Name");
        labelname.setBounds(560,310,100,30);
        add(labelname);
        
        JLabel lblname = new  JLabel();
        lblname.setBounds(660,310,100,30);
        add(lblname);
        
        JLabel labelphone = new  JLabel("Phone");
        labelphone.setBounds(560,340,100,30);
        add(labelphone);
        
        JLabel lblphone = new  JLabel();
        lblphone.setBounds(660,340,100,30);
        add(lblphone);
        
        JLabel labelemail = new  JLabel("Email");
        labelemail.setBounds(560,370,100,30);
        add(labelemail);
        
        JLabel lblemail = new  JLabel();
        lblemail.setBounds(660,370,100,30);
        add(lblemail);
        
        try{ 
              Conn c = new Conn();
              String query = " select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
              ResultSet rs = c.s.executeQuery(query);
              while(rs.next()){
                   lblname.setText(rs.getString("name"));
                   lblphone.setText(rs.getString("phone"));
                   lblemail.setText(rs.getString("email"));
                }

           } catch(Exception e){
             e.printStackTrace();
        }
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{ 
                    Conn c = new Conn();
                    String query = " select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                      lblname.setText(rs.getString("name"));
                      lblphone.setText(rs.getString("phone"));
                      lblemail.setText(rs.getString("email"));
                }

           } catch(Exception e){
             e.printStackTrace();
        }
            }
        });
        
         delete = new JButton("Delete");
        delete.setBounds(560,500,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        ImageIcon BackImage = new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Employ Management.System\\src\\icons\\Back.png");
        back = new JButton("Back",BackImage);
        back.setBounds(700,500,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(770,175,600,400);
        add(image);
        
       
        setSize(1920,1080);
        setLocation(0,0);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == delete){
              try{
                  Conn c = new Conn();
                  String query = "Delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                  c.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null,"  Employee Information Deleted Sucessfully ");
                  setVisible(false);
              }catch(Exception e){
                  e.printStackTrace();
              }
          }else{
              setVisible(false);
              new Home();
          }
             
              }
    
    public static void main(String[]args){
        new RemoveEmployee();
    }
}
