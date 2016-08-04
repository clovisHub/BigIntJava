

import javax.swing.JOptionPane;

public class IntegralTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integrals integ = new Integrals();
		SumArea sum = new SumArea();
		
		/*String curve = JOptionPane.showInputDialog(null, " enter the equation line for example -2 x exponent 3, you will enter: -2x3");
		String axis = JOptionPane.showInputDialog(null, "Enter the value of x, for x = 3, just enter 3");
		int x = Integer.valueOf(axis);
		JOptionPane.showMessageDialog(null, " You entered the equation : "+curve+"\n"+" for x equals "+axis+"\n"
		+"the function of X is : " + sum.functionOfX(curve, x));
		
		String linear = JOptionPane.showInputDialog(null, " enter the equation to integrate:");
		JOptionPane.showMessageDialog(null, "the integral of "+linear+ " is "+ integ.integrate(linear));
		
		String start = JOptionPane.showInputDialog(null, "Enter the starting value");
		int begin = Integer.valueOf(start);
		String end = JOptionPane.showInputDialog(null, "Enter the ending value");
		int finish = Integer.valueOf(end);
		
		JOptionPane.showMessageDialog(null,"Here is the integral : "+ integ.Answer(begin,finish ,linear ));*/
		
		
		String function = "3x3+4";
		
		int start = 2;
		int end = 4;
		int slice = 10;
		int portion = 1000;
		System.out.println("The integral of "+function+" is :"+integ.integrate(function));
		System.out.println("The integral of this function as an improper integrals from "+start+" to "+end+ " is "+integ.Answer(start, end, function));
		
		sum.setComponent(integ.integrate(function), start, end, slice);
		System.out.println("If the sum of "+slice+" Slices areas from "+start+" to "+end+" is "+sum.calculateSumArea());
		
		sum.setComponent(integ.integrate(function), start, end, portion);
		System.out.println("When the sum of "+portion+" Slices areas from "+start+" to "+end+" is "+sum.calculateSumArea());
		
		System.out.println("Obviously, with more slices the best is the approximation");
		
		
		
		
		
		
		
	
		
		
		

	}

}
