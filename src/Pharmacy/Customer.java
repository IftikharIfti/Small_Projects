package Pharmacy;

import java.text.SimpleDateFormat;
import java.util.*;

public class Customer {
    static int cnt=0;
    private String id="";
    private String age;
    private String BG;
    private String his;
    private HashMap<String,Integer> hm=new HashMap<>();
    int sum=0;
    public void addAge()
    {
     Scanner inp=new Scanner(System.in);
     age=inp.nextLine();
    }
    public void addBloodGrp()
    {
     Scanner inp=new Scanner(System.in);
     BG=inp.nextLine();
    }
    public void addHistory()
    {
      String inpt;
      Medicine[] med=new Medicine[100];

      System.out.println("Enter patient history");
      Scanner inp = new Scanner(System.in);
      inpt=inp.nextLine();
      his=inpt;
       System.out.println("Enter medicines:");
       int x,i=0;
       String meds,medname;
       while(true)
       {
        System.out.println("Press 0 to stop taking input 1 to continue");
        x=inp.nextInt();
        if(x==1)
        {
        sum=0;
        Scanner inp2=new Scanner(System.in);
        System.out.println("Enter the name of the medicine");
        medname=inp2.nextLine();
        System.out.println("How many doses per day?(x+y+z format)");
        meds=inp2.nextLine();
        med[i]=new Medicine(meds);
        sum+=med[i].totalMeds();
        System.out.println("How many days the medication?");
        x=inp2.nextInt();
        sum*=x;
        hm.put(medname, sum);
        i++;
        }
        else break;
       }
    }
    public void generateID()
    {
        cnt++;
        String cc=Integer.toString(cnt);
        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("MM-dd");
        String dt=formatter.format(date);
        id=dt+"-"+BG+"-"+age+"-"+cc;
        System.out.println("ID is "+id);
        System.out.println("Patient Age:"+age);
        System.out.println("Patient History "+his);
        System.out.println(hm);
    }
   
}
