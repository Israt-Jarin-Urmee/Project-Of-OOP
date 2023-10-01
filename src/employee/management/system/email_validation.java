
package employee.management.system;

import java.util.Scanner;

public class email_validation   {
    static boolean isValid (String email){
        
        String regex =  "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(regex);
    }
           
 public static void main(String[]args){
Scanner sc = new Scanner (System.in);
String email;
int x;
for(x = 0; x<=3; x++ ){
            System.out.println("Enter the Email address : ");
            email = sc.next();
                        System.out.print("\nThe Email address is : " + email);
                               System.out.print("\nIs the above Email address valid ? " + isValid(email));

            System.out.println();
         }
    }
}

