import java.util.*;
class Shirt
{
	int c,s;
    String material;

    Shirt(int c1,int s1,String m)
    {
    	c=c1;
        s=s1;
        material=m;
    }
    {
    	c=0;
        s=0;
        material="cotton";
    }
    
    void display(int c1,int s1,String m)
    {
    	
        System.out.println(c);
        System.out.println(s);
        System.out.println(m);
    }
}
class ShirtDemo
{
	public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
        System.out.println("Enter the collar size, sleevelength and material of the shirt");
        int c2=sc.nextInt();
        int s2=sc.nextInt();
        String m2=sc.next();
        Shirt sb=new Shirt(c2,s2,m2);
        sb.display(c2,s2,m2);
        
    }
}