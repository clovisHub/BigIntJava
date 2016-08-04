

import java.util.ArrayList;

public class Integrals extends SumArea{
	
	private String functionLine;
	
	public Integrals(){
		
		super();
		functionLine = "";
	}
	
	public String integrate(String y){
		String newFunction;
		
		if(y == "0"){
			
			System.out.println("Invalid entry");
			System.exit(0);
			newFunction = "";
		}
		else{
			
			functionLine = y;
		    newFunction = antiderivate(functionLine);
			newFunction = reWriteFunction(newFunction);
				
		}
		
		
		return newFunction;
	}
	
	private String reWriteFunction(String function){
		
		String reWrite ="";
		
		ArrayList <String> portion = new ArrayList<String>();
		
		function = function.trim();
		
		int length = function.length();
		
		int i = 0;
		
		while (i+2 <= length ){
			
			if(function.charAt(i)== 'x'  ){
				
				if(i+2 <= function.length()-1){
					
					portion.add(function.substring(0,i+2));
				}
				 if(i+2 == function.length()){
					 
					portion.add(function.substring(0, i+2));
					break;
				}
				else{
					
					if(i+2 >= function.length()-1){
						portion.add(function.substring(0,i+1));
						break;
					}
					else{
						function = function.substring(i+2);
					}
					
				}
				
				i = 0;
			}
			
			i++;
		}
		
		 for(int j = 0; j < portion.size(); j++){
			 
			 if(portion.get(j).trim().charAt(0) == '-' || portion.get(j).trim().charAt(0)=='+'){
				 
				 reWrite += ""+portion.get(j).trim()+" ";
				 
			 }
			 else{
				 
				 reWrite += "+"+portion.get(j).trim()+" ";
			 }
			 
		 }
		
		return reWrite;
	}
    
	public double integrateNumber(double number, String y){
		
		double value = 0;
		
		String newCurve = integrate(y);
	    	
		value = this.functionOfX(newCurve, number);
	
		return value;
	}
	
	private String antiderivate(String function){
		
		String reply = "";
		
		
		ArrayList <String> portion = new ArrayList <String>();
		
		portion.addAll(super.getComponent(function));
		
		int expo = 0;
	    double number = 0;
	    
		for (int i = 0; i < portion.size(); i++){
			
	          expo = super.myExponent(portion.get(i).trim());
	          
	          if(expo != -1 && expo != 0){
	        	  
	        	  expo += 1;
	        	  number = super.myValue(portion.get(i).trim());
	        	  number /= expo;
	        	  
	        	  if(number != 0 && number != 1 && number != -1){
	        		  
	        		  reply += number+"x"+expo+" ";
	        	  }
	        	  else{
	        		  
	        		  reply += "x"+expo+" ";
	        		  
	        	  }
	        	  
	          }
	          else if(expo == 0){
	        	  
	        	   if(super.myValue(portion.get(i))!= 0){
	        		   reply += super.myValue(portion.get(i).trim())+"x";
	        	   }
	        	   else{
	        		   reply +="";
	        	   }
	          }
	          else{
	        	  
	        	  reply += " +ln [1/x] ";
	        	  
	          }
	          
		}
		return reply;
	}
	
	public double Answer(double lower, double upper, String y){
		
		double response;
		
		response = this.integrateNumber(upper, y)- this.integrateNumber(lower, y);
		
		return response;
	}
	
	public String toString(){
		
		super.toString();
		
		String myAnswer = ""+ this.antiderivate(functionLine);//+"\n"
		//+ //this.intregateNumber(end,functionLine)+"\n"
	    //+ this.intregateNumber(from, functionLine)+"\n"
		//+ "equals "+ Answer(from, end, functionLine);
		
		return myAnswer;
	}
	
}
