package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener  {
    
    JTextField tfusername ;
    JPasswordField tfpassword;
    
     Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(600,300,100,30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(700,300,150,30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(600,350,100,30);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(700,350,150,30);
        add(tfpassword);
        
        JButton login = new JButton (" LOGIN");
        login.setBounds(700,430,150,50);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(850,250,200,200);
        add(image);
        
        setSize(1920,1080);
        setLocation(0,0);
        setVisible(true);
        }
    @Override
      public void actionPerformed(ActionEvent ae){
          try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                 setVisible(false);
                 new Home();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                 setVisible(false);
            }
    } catch(Exception e){
       e.printStackTrace();
         }
          
      }
      public static void main(String[]args){
        new Login();
     }
}
      


