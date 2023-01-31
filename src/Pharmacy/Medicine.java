package Pharmacy;

public class Medicine {
    private String s;
    private int tt;
    public Medicine(String x)
    {
        s=x;
    }
    public int totalMeds()
    {
      
     String [] parts=s.split("\\+");
     int pt1=Integer.parseInt(parts[0]);
     int pt2=Integer.parseInt(parts[1]);
     int pt3=Integer.parseInt(parts[2]);
     tt=pt1+pt2+pt3;
     return tt;
    }
}
