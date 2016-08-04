

import java.util.Scanner;

public class ParabolaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		Parabola parabo = new Parabola();
		System.out.println(" Enter your parabola equation! for y square equals 9x, enter y2 = 9x,"+"\n"+" for x square equals minus 0.004y, enter x2 = - 0.004 y");
		String data = input.nextLine();
		
		parabo.setComponent(data);
		
		System.out.println(" p equals : "+parabo.getP());
		
		parabo.focusParabola();
		
		parabo.directrixParabola();
		
		System.out.println("Enter your y value or your x value");
		double coordinate = input.nextDouble();
		System.out.println(" is it an x value? if yes enter yes otherwise enter no");
		String reply = input.next();
		
		int count = 0;
		double coordinate2;
		
		while(count < 3 ){
			
			if(reply.equalsIgnoreCase("yes")){
				
				reply = "x";
				coordinate2 = parabo.myXorYcoordinate(reply, coordinate);
				System.out.println(" the y value is : Y = "+coordinate2);
				
				break;
			}
			else if(reply.equalsIgnoreCase("no")){
				
				reply = "y";
				coordinate2 = parabo.myXorYcoordinate(reply, coordinate);
				System.out.println(" the x value is : X = "+coordinate2);
				break;
			}
			else{
				
			    System.out.println("wrong answer, please enter yes or no!");
			    System.out.println("try enter again! ");
			    
			}
			if(count == 3){
				
				System.out.println("It was the last time. Good bye!");
				System.exit(0);
			}
		}
		
		
	
	}

	
	
}

