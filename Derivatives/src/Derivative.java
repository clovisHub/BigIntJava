
import java.util.ArrayList;


public class Derivative {
	
	private int exponent;
	private String sign;;
	private int number;
	private String variable;
	private ArrayList <String > component = new ArrayList < String>();
	
	
	public Derivative(String symbol, int value,String unknown, int exp){
		
		sign = symbol;
		
		exponent = exp;
		
		number = value;
		
		variable = unknown;
		
	}
	
	public Derivative(String operation, String parentheses, int power){
	
		sign = operation;
		
		variable = parentheses;
		
		exponent = power;
		

	}
	
	public String chainRule(String signe, String brakets, int power){
		
		String answer ="";
		String toDerive ="";
		int value = 0;
		
		
		sign = signe;
		exponent = power -1;
		
		if(sign.equalsIgnoreCase("-")){
			
			value = -1;
		}
		else{
		    value = 1;
		}
		
		toDerive = brakets;
		 
		if(toDerive.charAt(0)=='(' && toDerive.charAt(toDerive.length()-1)== ')'){
			toDerive = toDerive.substring(1);
			toDerive = toDerive.substring(0, toDerive.lastIndexOf(toDerive));
			
		}
		
		
		answer += ""+(power*value)+ brakets+"^"+exponent+" ";
		
		return null;
	}
	
	
	
	
	public String derivativeOf(){
		
		String data ="";
		
		
		if(exponent != 0){
			
			number = exponent*number;
			exponent = exponent -1;
			
			if(number < 0 && sign.equalsIgnoreCase("-")){
				
				number = -1*number;
				sign ="+";
			}
			else if (sign == null)
			{
				
				sign ="";
			}
			else{
				
				// nothing is done
			}

			data = sign+number+ variable+"^"+exponent;
		}
		else{
			    
				data = ""+number;		
		}
		
		return data;
	}
	
}
	



