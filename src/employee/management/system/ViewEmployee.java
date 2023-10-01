package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;
    Choice cemployeeId;
    JButton search,print,update,back;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(600,50,150,20);
        add(searchlbl);
        cemployeeId = new Choice();
        cemployeeId.setBounds(750,50,150,20);
        add(cemployeeId);
        
        table = new JTable();
        try{ 
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select*from employee");
             
              while(rs.next()){
                  cemployeeId.add(rs.getString("empId"));
              }

           } catch(Exception e){
             e.printStackTrace();
    }
            try{ 
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from employee");
              table.setModel(DbUtils.resultSetToTableModel(rs));
              while(rs.next()){
                  cemployeeId.add(rs.getString("empId"));
              }

           } catch(Exception e){
             e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(300,180,900,500);
        add(jsp);
            
        search = new JButton ("search");
        search.setBounds(550,120,80,20);
        search.addActionListener(this);
        add(search);
        
        print= new JButton ("print");
        print.setBounds(650,120,80,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton ("update");
        update.setBounds(750,120,80,20);
        update.addActionListener(this);
        add(update);
        
        ImageIcon BackImage = new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Employ Management.System\\src\\icons\\Back.png");
        back = new JButton ("Back",BackImage);
        back.setBounds(850,120,80,20);
        back.addActionListener(this);
        add(back);
        
        setSize(1920,1080);
        setLocation(0,0);
        setVisible(true);
        
}
    @Override
     public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== search){
            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'"; 
            try{
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery(query);
              table.setModel(DbUtils.resultSetToTableModel(rs));
             
            } catch(Exception e){
              e.printStackTrace();
    }
           
        }else if(ae.getSource()== print){
            
            try{
              table.print();
     
        } catch(Exception e){
           e.printStackTrace();
    }
            
            
        }else if(ae.getSource()== update){
            
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
            
        }else{
             setVisible(false);
            new Home();
            
        }
            
        }
    
    
    public static void main(String[]args){
        new ViewEmployee();
    }
    
}
