

import java.util.Scanner;

public class Ackermann {
	
	private int m, n;
	private static int count;
	
	public Ackermann()
	{
		m = 0;
		n = 0;
		count = 0;
	}
	
	public static int ackValue(int m, int n)
	{
		count = count+1;
		
		int x = 0;
	
		if(m == 0)
		{
			System.out.println("count = "+ count + " "+"m = "+ m+ " "+"n = "+ n);
			x = n+1;
			
		}
		else
		{
			if( n == 0)
			{
				System.out.println("count = "+ count + " "+"m = "+ m+ " "+"n = "+ n);
			    m = m-1;
			    n = 1;
			    x = ackValue( m, n);
			 
			}
			else
			{
				System.out.println("count = "+ count + " "+"m = "+ m+ " "+"n = "+ n);
				n = ackValue(m, n-1);
				m = m-1;
				x = ackValue(m,n);
				
			}
		}
	   
       
       return x;
	}
	
	
	public static void main(String []args)
	
	{
	   int n, m, result;
	   
	   Scanner obj = new Scanner(System.in);
	   System.out.println(" enter m value");
	   m = obj.nextInt();
	   System.out.println(" enter n value");
	   n = obj.nextInt();
	   
	   result = ackValue(m,n);
	   
	   System.out.println("Ackermann value for m = 3 and n = 2 is " + result);
	   
	   
	}
	

}
