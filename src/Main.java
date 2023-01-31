/* 
██╗███████╗████████╗██╗
██║██╔════╝╚══██╔══╝██║
██║█████╗     ██║   ██║
██║██╔══╝     ██║   ██║
██║██║        ██║   ██║
*/
import java.util.*;
import Pharmacy.Customer;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to pharmacy management system");
        int option;
        Scanner scan=new Scanner(System.in);
        Customer c=new Customer();
        while(true)
        {
        System.out.println("Complete the following infos");
        System.out.println("1.Age");
        System.out.println("2.Blood Group");
        System.out.println("3.Medical History");
        System.out.println("4.Done");
        System.out.println("5.Exit");
        int cnt=0;
        boolean op1=false,op2=false,op3=false,ext=false;
       
        while(true){
            option=scan.nextInt();
          if(option==1&&op1==false)
          {
            System.out.println();
          c.addAge();
          op1=true;
          }
          if(option==2&&op2==false)
          {
            c.addBloodGrp();
            op2=true;  
          }
        
          if(option==3&&op3==false){
              op3=true;
          c.addHistory();
          }
       
          if(option==4){
          if(op1==true&&op2==true&&op3==true)
          {
            System.out.println("Resgistraion Done");
            c.generateID();
            break;
          }
          else  System.out.println("Complete registration");
        }
        if(option==5) 
        {
          ext=true;
          break;
        }
        }
        if(ext==true)
        {
          System.out.println("Program ended");
           break;
        }
        }
    }
}
