package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfname,tffname,tfsalary,tfaddress ,tfphone,tfemail,tfdesignation;
            JDateChooser dcdob;
            JComboBox cbeducation;
            JLabel lblempId;
            JButton add,back;
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(700,70,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(470,150,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(550,150,150,30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(750,150,150,30);
        labelfname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(900,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(470,200,150,30);
        labeldob.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(580,200,120,30);
        add(dcdob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(750,200,150,30);
        labelsalary.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(900,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Addresss");
        labeladdress.setBounds(470,250,150,30);
        labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(550,250,150,30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(750,250,150,30);
        labelphone.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(900,250,150,30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(470,300,150,30);
        labelemail.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(550,300,150,30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(750,300,150,30);
        labeleducation.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeleducation);
        String courses[] = {"BBA","BCA","BA","BSC","MBA","MCA","MA","MSC","PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(930,300,120,30);
        add(cbeducation);
        
        JLabel labeldesignation= new JLabel("Designation");
        labeldesignation.setBounds(470,350,140,30);
        labeldesignation.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation= new JTextField();
        tfdesignation.setBounds(570,350,150,30);
        add(tfdesignation);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(470,400,150,30);
        labelempId.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelempId);
        
        lblempId= new JLabel(""+number);
        lblempId.setBounds(600,400,150,30);
        lblempId.setFont(new Font("SERIF",Font.PLAIN,20));
        add(lblempId);
       
        ImageIcon AddImage = new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Employ Management.System\\src\\icons\\Add.png");
        add = new JButton ("Add Details",AddImage);
        add.setBounds(600,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
       
       ImageIcon BackImage = new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Employ Management.System\\src\\icons\\Back.png");
       back = new JButton ("Back",BackImage);
       back.setBounds(850,550,150,40);
       back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       add(back);

              
        setSize(1920,1080);
        setLocation(0,0);
        setVisible(true);
    
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name = tfname.getText();
            String fname= tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary= tfsalary.getText();
            String address= tfaddress.getText();
            String phone= tfphone.getText();
            String email= tfemail.getText();
            String education = (String)cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String empId = lblempId.getText();
            
            try{
            Conn conn = new Conn();
            String query =" insert into employee values( '"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+empId+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details added successfully");
            setVisible(false);
            new Home();
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
     
        }
        
    }
    public static void main(String[]args){
        new AddEmployee();
     }
    
}
