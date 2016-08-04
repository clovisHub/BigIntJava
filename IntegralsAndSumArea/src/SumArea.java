

import java.util.ArrayList;

public class SumArea {
 
	private double begin;
	private String curve;
	private double end;
	private double deltaX;
	private double [] functionOfX;
	//private static final double PI = 22/7;
	
	
	public SumArea(){
		
		curve = "";
		begin = 0;
		end = 0;
		deltaX = 0;
		functionOfX = null;
	}
	
	public void setComponent(String function, int start, int finish, int slices){
		
		curve =function;
		begin = start;
		end = finish;
		functionOfX = new double[slices];
		deltaX = (end-begin)/functionOfX.length;
		
	}
	
	public String getCurve(){
		return curve;
	}
	public double getBegin(){
		return begin;
	}
	public double getEnd(){
		return end;
	}
	
	public ArrayList <String> getComponent(String function){
		
		String reply ="";
		
		ArrayList<String> parts = new ArrayList <String>();
		
	    int i = 0; 
	    while (i<= function.length()-1){
			
			if(function.charAt(i)=='+'|| function.charAt(i)=='-' || i == function.length() ){
				
				parts.add(reply);
				
				reply ="";
			}
			
			reply += function.charAt(i);
			
			i++;
			
			if(i == function.length()){
				
				parts.add(reply);
			}
		}
		
	       
		return parts;
	}
	
	
	public int  myExponent(String part){
		
		int power = 0;
     
		 if(!(part.equalsIgnoreCase(""))){
			 
			 
			 if(part.charAt(part.length()-1) == 'x'){
					
					power  = 1;
				}
				else if(part.charAt(part.length()-2)!= 'x' && (part.charAt(part.length()-1)!= 'x')){
					
					power = 0;
				}
				else{
					
					power = Integer.valueOf(""+part.charAt(part.length()-1));
					
				}
			 
		 }
			
				
		return power;
	}
	
	
    public double  myValue(String part){
		
		double value = 0;
     
			
		if(!(part.equalsIgnoreCase(""))){
			
             if(part.charAt(part.length()-1) == 'x'){
            	
            	 if((part.length()==2 &&(part.charAt(0) == '+'|| part.charAt(0)=='-')) || (part.length()==1)){
            		 
            		 if(part.charAt(0)=='-'){
            			 value = -1;
            		 }
            		 else{
            			 value = 1;
            		 }
            	 }
            	 else{
            		 value = Double.valueOf(part.substring(0, part.length()-1));
            	 }
				
				
			}
			else if(part.charAt(part.length()-2)!= 'x'&& part.length()>= 1){
				
				String val ="";
				
				for(int i =0; i < part.length(); i++){
					
					if(part.charAt(i)== 'x'){
						val = ""+1;
						break;
					}
					val+= part.charAt(i);
				}
			
				value = Double.valueOf(val);
			}
			else{
				
				if(part.length()== 2 && part.charAt(part.length()-1)!= 'x'&& part.charAt(part.length()-2)=='x'){
					value = 1;
				}
				else if(part.length()== 3 && part.charAt(1)== 'x'&& (part.charAt(0)== '-'||part.charAt(0)=='+')){
					
					if(part.charAt(0)== '-'){
						value = -1;
					}
					else{
						value = 1;
					}
				}
				else{
					value = Double.valueOf(""+part.substring(0, part.indexOf('x')));
				}
				
				
			}
		}
			
				
		return value;
	}
	
	
	public Double functionOfX(String Y, double interval){
		
		double ordinate = 0 ;
		
		ArrayList<String> component = new ArrayList <String>();
		
		component.addAll(getComponent(Y));
		
		int times = component.size();
		
		int c = 0;
		int power;
		double numb;
		
		while(c < times){
			
			power = myExponent(component.get(c).trim());
			numb = myValue(component.get(c));
			
			ordinate += Math.pow(interval, power)* numb;
			c++;
		}
		

		return ordinate;
	}
	
	public double calculateSumArea(){
		
		double sumArea = 0;
		
		functionOfX[0]= getBegin();
		System.out.println(deltaX);
		
	    for(int j = 1; j< functionOfX.length; j++){
	    	
	    	if(j == 0){
	    		
	    		functionOfX[j]+= getBegin();
	    	}
	    	else{
	    		functionOfX[j]= functionOfX[j-1]+deltaX;
	    	}
	    	
	    }
	    
	    double []y = new double[functionOfX.length];
	    
	    for(int k = 0; k < y.length; k++){
	    	
	    	y[k]= functionOfX(curve, functionOfX[k]);
	    	 
	    	
	    	sumArea += surfaceArea(y[k]);
	    	
	    	
	    }
	    
	    return sumArea;
	}

	public double surfaceArea(double y){
		
		
		double surface = deltaX* y;
		
		return surface;
	}
	
	
}
