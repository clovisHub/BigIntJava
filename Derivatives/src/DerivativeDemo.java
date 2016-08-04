import javax.swing.JOptionPane;


public class DerivativeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 JOptionPane.showMessageDialog(null," Enter you equation");
		 
		 String sign = JOptionPane.showInputDialog("enter sign ");
		 
		 if(sign == null || sign == ""){
		
			 JOptionPane.showMessageDialog(null, " you entered nothing so your sign will be positive");
		 }
		 else{
			 JOptionPane.showMessageDialog(null, " you entered "+ sign); 
		 }
		 
		 
		 String value =  JOptionPane.showInputDialog("enter its value");
		 
		 int number = Integer.valueOf(value);
		 JOptionPane.showMessageDialog(null, " you entered "+ number);
		 
		 String variable = JOptionPane.showInputDialog("enter the variable");
		 
		 JOptionPane.showMessageDialog(null, " you have "+ variable);
		 
		 String power = JOptionPane.showInputDialog("enter the exponent");
		 int expo = Integer.valueOf(power);
		 
		 JOptionPane.showMessageDialog(null, " you entered "+ power);
		 
		Derivative obj = new Derivative(sign, number, variable,expo );
		
		String val = obj.derivativeOf();
		
		if (sign != null){
			
			JOptionPane.showMessageDialog(null,"the derivative of: " +sign+" "+number+variable+"^"+expo+" equals "+val);

		}else{
			
			JOptionPane.showMessageDialog(null,"the derivative of: " +number+variable+"^"+expo+" equals "+val);

		}
		

	}

}
