

public class Parabola {
	
	private String function;
	private String sign;
	private double p;
	private String curve;
	
	public Parabola(){
		function = "";
		sign ="";
		p = 0;
		curve ="";
	}
	
	public void setComponent(String equation){
		
	    int i = 0;
	
	    String data ="";
	    
	    for(int a = 0; a < equation.length(); a++){
	    	
	    	if(equation.charAt(a)!= ' '){
	    		
	    		 data += String.valueOf(equation.charAt(a));

	    	}
	    }
	    
	    
	    if(data.charAt(1)!= '2'){
	    	
	    	System.out.println("Invalid Entry! the parabola function must look like y2 = ax or x2 = ay when a = 4*p" );
	    	System.out.println();
	    	System.out.println("Check your data and enter again please!");
	    	
	    	System.exit(0);
	    }
		
		while(i < data.length()){
			
			int j =0;
			
			while( j <10){
					if(j == i){
						break;
			     }
					j++;
			  }
			
			if(data.charAt(i)=='-'||data.charAt(i)=='+'||data.charAt(i)=='p'||data.charAt(i)=='x'||data.charAt(i)== 'y'||data.charAt(i)=='-'|| j == i){
				
				i++;
			}
			else{
				
				System.out.println("Invalid entry");
				System.exit(0);
			}
			
		}
		
		function = String.valueOf(data.charAt(0));
		
		if(data.charAt(3)== '-'|| data.charAt(3)=='+'){
			
			sign = String.valueOf(data.charAt(3));
			curve = data.trim().substring(4); 
		}
		else{
			
			curve = data.trim().substring(3);
		}
		
		  String value = "";
			
			for(int x = 0; x < curve.length()-1; x++){
				
				if(curve.charAt(x)!= 'p'){
					
				  value += String.valueOf(curve.charAt(x));
				}
				else{
					
					break;
				}
			}
			p = Double.valueOf(value)/4;
		
	}

	public double getP(){
		
		return p;
	}
	private String getSign(){
		return sign;
	}
	
	public double myXorYcoordinate(String variable, double value){
		
		if(variable.equalsIgnoreCase(function)){
			
			value = this.myInverseFunct(value);
		}
		else{
			
			value = myFunction(value);
		}
		
		return value;
	}
	private double myFunction(double value){
		 
		double functionValueSquare = 0;
		
		if(getSign()== "-"){
			
			functionValueSquare = -4 * getP()* value;
		}
		else{
			
			functionValueSquare = 4 * getP()* value;
		}
		
		return functionValueSquare;
	}
	
	private double myInverseFunct(double funct){
		
		double variant = 0;
		
		if(getP()!= 0 && getSign().equalsIgnoreCase("-")){
			
			double pow = Math.pow(funct, 2);
			double dem = 4*getP();
			variant = pow/dem;
			variant = -1*variant;
		}
		else if(getP()!=0){
			
			double pow = Math.pow(funct, 2);
			double dem = 4*getP();
			variant = pow/dem;
		}
		else{
			
			System.out.println("You may have an error, p is not supposed to be zero");
		}
		
		return variant;
	}
	
	public void focusParabola(){
		
		double p1 = getP();
		
		if(sign.equalsIgnoreCase("-") && function.equalsIgnoreCase("y")){
			
			
			System.out.println(" The focus is: F("+ -p +" , 0 )");
		}
		else if(sign.equalsIgnoreCase("-") && function.equalsIgnoreCase("x")){
			
			System.out.println(" The focus is: F( 0 , "+ -p+" )");
		}
		else if(function.equalsIgnoreCase("y")){
			
			System.out.println(" The focus is: F("+p1+" , 0 )");
		}
		else{
			
			System.out.println(" The focus is: F( 0 , "+p1+" )");
		}
		
	}
	
	public void directrixParabola(){
		
		double d;
		
		if(p >0 && function.equalsIgnoreCase("y")){
			
			d = -1* p;
			
			System.out.println(" the directrix is x = "+ d);
			
		}
		else if( p<0 && function.equalsIgnoreCase("y")){
			
			d = -1* p;
			System.out.println(" the directrix is x = "+d);
		}
		else {
			
			d = -1* p;
			System.out.println(" the directrix is y = "+d);
			
		}
		
	}
	

	
}
