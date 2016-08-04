
import java.util.Scanner;

public class Pseries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
	    System.out.println("Enter exponent of the p series");
		int p = input.nextInt();
		System.out.println("Enter numerator of the p series");
		int numerator = input.nextInt();
		System.out.println("Enter denominator of the p series");
		double denominator = input.nextDouble();
		
		
		double [] Pseries = new double[p+1];
		
		
		if(denominator == 0){
			
			System.out.println("You can not have zero as a denominator enter different value");
			System.out.println(" Please restart and try again");
			System.exit(0);
		}
		
		int start = 0;
		double ratio;
		double sum = 0;
		double a = 0;
		double under = 1;
		
		while(start <= p){
			
			under = (int) Math.pow(denominator, start);
			ratio = numerator/under;
			Pseries[start]= ratio;
			a = ratio;
			System.out.println(a);
			sum += ratio;
			System.out.println("at p equals: "+start+", A"+start+" is : "+numerator+" over "+ (int)under+" equals "+a);
			System.out.println();
			start++;
			a = 0;
		}
        System.out.println("the sum is : "+sum);
	
	}

}
