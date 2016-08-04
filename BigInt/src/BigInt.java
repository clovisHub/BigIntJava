


import java.util.ArrayList;
import java.util.InputMismatchException;


public class BigInt {
 
	private ArrayList <Integer> numerical;
 
	private boolean negative;
 
    // this constructor is for temporary object (result object after an arithmetic operation)
	public BigInt(){
  
		numerical = new ArrayList <Integer>();
        negative = false;
 
	}
 
	// creates a value and check if it is a real number without specific characters
	public BigInt(String unit){
  
		numerical = new ArrayList<Integer>();
        negative = setSign(unit);
        unit = removeSign(unit);
  
    
        try{
     
        	int n =0;
            for (int i = unit.length()-1; i>=0; i-- ){   
      
            	boolean l = Character.isDigit(unit.charAt(i));
                if(l == true){
            
                	Character c = new Character (unit.charAt(i));
            
                	String s = c.toString(); 
                    n = Integer.parseInt(s);
                 }
                 else
                 {
        
                	 System.exit(0);
                  }
        
                numerical.add(n);
     
              }
     
          }
          catch(InputMismatchException e)
          {
                System.out.println("invalid entry!");
                System.exit(0);
          }
  
 }
    // If there is a sign on a number created, it removes it.
	//reference: constructor BigInt(string unit)
    private String removeSign(String unit) {    
      unit.trim();
  
         if(unit.charAt(0)=='+'|| unit.charAt(0)=='-'){
        	 unit = unit.substring(1);
         }
         else{ 
        	 unit= ""+unit;
        	 }
  
         return unit;
    }
 
    //It saves sign for each number involved to compare with sign will take the final result
    private Boolean setSign(String unit) {
        if(unit.charAt(0)=='-'){ negative = true; }
        else { negative = false;}
  
       return negative;
   } 
 
   // If an number is greater than the other number, the result might take the value of the greater one
   public boolean isGreaterThan(ArrayList<Integer> array1,ArrayList<Integer> array2){     
        
	   Boolean result = false;
      
      if(array1.size()== array2.size()){
       
           for(int i = array1.size()-1; i >=0;i--) {
        	   
                 if(array1.get(i)>array2.get(i)){
                         result = true;
                         break;
                 }
                 else if(array1.get(i)<array2.get(i)){
                         result = false;
                         break;
                 }
        
           }
          
       }
       else if( array1.size() > array2.size()){
           result = true;
       }
       else {
           result = false;
       }
   
      return result; 
    
   }       
  
   public BigInt add(BigInt otherObjt)
   {
    BigInt objt = new BigInt();
   
    if(this.negative == otherObjt.negative)
    { 
        objt.negative = this.negative;
        objt.numerical = addArray(this.numerical, otherObjt.numerical);
    }
    else
    {
        boolean yes = isGreaterThan(this.numerical, otherObjt.numerical);
        
        if(yes== true)
        { 
            objt.negative = this.negative; 
            objt.numerical = subtractArray(this.numerical, otherObjt.numerical);
        }
        else
        {
            objt.negative = otherObjt.negative;
            objt.numerical = subtractArray(otherObjt.numerical, this.numerical);
        }
        
    }
  
  return objt;
 }
 
 private ArrayList<Integer> addArray(ArrayList<Integer> first, ArrayList<Integer> second) {
        
        int carry = new Integer(0); 
  int answer = 0;
  Integer result = 0;
  ArrayList <Integer> total = new ArrayList<Integer>();
  
  int limite = 0;
  
  if(first.size()> second.size())
  {
   limite = first.size()+1;
  }
  else
  {
   limite = second.size()+1;
  }
  
  ArrayList <Integer> takeFirst = new ArrayList<Integer>(limite);
  ArrayList <Integer> takeSecond = new ArrayList<Integer>(limite);
  
  for(int i= 0; i < limite; i++)
  {
   takeFirst.add(0);
   takeSecond.add(0);
  }
  
  
  for(int i = 0; i < takeSecond.size(); i++)
  {
   if(i< first.size())
   {
    takeFirst.set(i, first.get(i));
   }
   
      if(i< second.size())
   {
    takeSecond.set(i, second.get(i));
   }
   
  }
  
  
    for ( int i =0; i < takeFirst.size(); i++)
    {
  
         result = carry + takeFirst.get(i)+ takeSecond.get(i);
         answer = result%10;
      
         if (result/10 ==1)
         {
          carry = 1;
         }
         else
         {
          carry = 0;
         }
         total.add(answer); 
    }
    
    if(0 == total.get(limite-1))
    {
     total.remove(limite-1);
    }
 
 total = checkZero(total);
 return total;
}
    public BigInt subtract(BigInt otherObjt)
    {
     BigInt objt = new BigInt();
     
     if(this.negative!= otherObjt.negative)
     {
      if(this.negative == true)
      {
             objt.negative = this.negative;
             objt.numerical = addArray(this.numerical, otherObjt.numerical);
      }
      else
      {
          objt.negative = this.negative;
               objt.numerical = addArray(this.numerical, otherObjt.numerical);
      }
      
     }
     if(this.negative == otherObjt.negative)
     {
      boolean yes = isGreaterThan(this.numerical, otherObjt.numerical);
      
      if(yes==true)
      {   
           objt.negative = this.negative;
              objt.numerical = subtractArray(this.numerical, otherObjt.numerical);
      }
      else
      {
       if(otherObjt.negative == true)
       {
           objt.negative = !(otherObjt.negative );
           objt.numerical = subtractArray(otherObjt.numerical, this.numerical);
       }
       else
       {
        objt.negative = !(otherObjt.negative);
        objt.numerical = subtractArray(otherObjt.numerical, this.numerical);
       }
      }
     }
      
     
     return objt;
    }
    private ArrayList<Integer> subtractArray(ArrayList<Integer> firstArray, ArrayList<Integer> secondArray)
    {
     ArrayList <Integer> remainder = new ArrayList<Integer>();
     
     ArrayList <Integer> takeFirst = new ArrayList<Integer>();
     ArrayList <Integer> takeSecond = new ArrayList<Integer>();
     
      for(int i = 0; i < firstArray.size(); i++)
      {
           takeSecond.add(0);
           takeFirst.add(0);
      }
      for(int i =0; i< takeFirst.size();i++)
      {
       if(i<secondArray.size()) { takeSecond.set(i, secondArray.get(i));}
       
       if(i<firstArray.size()) { takeFirst.set(i, firstArray.get(i));}
      
      }
     
      int keep = 0;
      
      // these three lines of codes are just writing out of the following for loop to make possible the use of the method " IndexOf(int ch, fromIndex) "
      // so it will work even if we have the same character with multiple locations(index) to have the rank.
      
      takeFirst = reverseArray(takeFirst);
      String myFirst = reverseThat(takeFirst);
      takeFirst = reverseArray(takeFirst);
      
      for(int i = 0; i < takeFirst.size(); i++)
      {
       
       if(takeFirst.get(i)< takeSecond.get(i))
       {  
        if(i >=0)
        takeFirst.set(i, 10+takeFirst.get(i));
        
        keep = takeFirst.get(i)- takeSecond.get(i);
        
        int rank = myFirst.indexOf(myFirst.charAt(i), i);
        
        while(rank < takeFirst.size())
        { 
         rank++;
         if(takeFirst.get(rank).equals(0))
         {
          takeFirst.set(rank, 9);
         }
         else
         {
          takeFirst.set(rank,takeFirst.get(rank)-1);
          break;
         }
         
        }
     
           }
        else
        {    
        keep = takeFirst.get(i)-takeSecond.get(i);
        
        }
        
       remainder.add(keep);
      }
     remainder = checkZero(remainder);
      
     return remainder;
    }
    
    public BigInt multiply(BigInt otherObjt)
    {
     BigInt product = new BigInt();
     
     if(this.negative == otherObjt.negative && this.negative == true)
     {
      product.negative = !(otherObjt.negative);
      product.numerical = multiplied( otherObjt.numerical, this.numerical);
     }
     else
     {
      product.negative = otherObjt.negative;
      product.numerical = multiplied(otherObjt.numerical,this.numerical);
     }
      
  
     return product;
    }
    
    private ArrayList<Integer> multiplied(ArrayList<Integer> array1, ArrayList<Integer> array2)
    {
     ArrayList<Integer> myProduct = new ArrayList<Integer>();
     ArrayList<Integer> myAnswer = new ArrayList<Integer>();
    
     for(int out = 0; out < array2.size(); out++)
     {  
         int position = out;
      
      myAnswer = times(array2.get(out), position, array1);
   
      myProduct = addArray(myProduct,myAnswer);
      
     }
     return myProduct;
    }
    
   private ArrayList<Integer> times(int arrayInt, int location, ArrayList <Integer> myArray)
   {
    ArrayList <Integer> product = new ArrayList<Integer>();
    
    int count = location;
    
    while (count>0)
    {
    count--;
    product.add(0); 
    }
     
    int val = arrayInt;
    int away =0;
    int result = 0;
    int keep;
    int j =0;
    
    while( j< myArray.size())
    {   
     int numb = myArray.get(j);
     result = (val* numb)+ away;
     keep = result%10;
     away = result/10;
     product.add(keep);
     j++;
    }
    
    if(away!=0)
    {
     product.add(away);
    }
    
    return product;
   }
  
    public BigInt divideBy(BigInt otherObjt)
    {
     BigInt quotient = new BigInt();
     
     if(this.negative == otherObjt.negative )
     {
      quotient.negative = false;
     }
     else
     {
      quotient.negative = true;
     }
     
     
     quotient.numerical = divideArray(this.numerical, otherObjt.numerical);
      
     return quotient;
    }
    
    
     
    private ArrayList<Integer> divideArray(ArrayList<Integer> firstArray, ArrayList<Integer>secondArray)
    {   
              ArrayList <Integer> myQuotien = new ArrayList<Integer>();
              ArrayList <Integer> isNotBigger = new ArrayList <Integer>();
              ArrayList <Integer> myAnswer = new ArrayList<Integer>();
              ArrayList <Integer> transformer = new ArrayList<Integer>();
              ArrayList <Integer> myQuo = new ArrayList<Integer>();
              
              
              // pass firstArray to transformer
             for(int i = 0; i< firstArray.size(); i++)
              {
              transformer.add(0);
              transformer.set(i,firstArray.get(i));
              }
             
             int answer;
             boolean isBigThan;
             boolean keepGoing;
             boolean theSameValue;
             
             
             
    do {
     
     isBigThan = isGreaterThan(transformer, secondArray);
     theSameValue = transformer.equals(secondArray);
     
     // if secondArray is not zero, transformer is till bigger than secondArray or there are equals
      if(!(secondArray.equals(0)) && isBigThan == true ||theSameValue == true )
      {
       int indice1 = transformer.size()-1;
       int index2 = secondArray.size()-1;
        int second = secondArray.get(index2);
        int result ;
        int first = transformer.get(indice1);
        
        ArrayList <Integer> difference = new ArrayList<Integer>();
         int myNumber = 0;
         int transforSize = 0;
         
            if(first>= second)
            {
            myNumber = first;
            transforSize = transformer.size();
            }
            else if(transformer.size()>=2)
            {
               
               String numb = reverseThat(transformer);
               String num = numb.substring(0, 2); 
               myNumber = Integer.valueOf(num); 
               transforSize = transformer.size()-1;
               
            }
            else
            {
             // do not anything
            }
            
              
            result = myNumber / second;
              
              myAnswer.add(result);
             
              isNotBigger = multiplied(secondArray, myAnswer);
              
             boolean transformerBeatIsNotBigger = isGreaterThan(transformer, isNotBigger);
             boolean thereEquals = transformer.equals(isNotBigger);
             
              //if transformer is greater than the product of secondArray times "possible result" or equals it.
            if(transformerBeatIsNotBigger == true || thereEquals == true)
            {
             // length is the number of possible zero missing to the product ( secondArray * answer)
             int length = transforSize -isNotBigger.size();
             
             if (length <0)
             {
              transforSize = transforSize +1;
              length = transforSize - isNotBigger.size();
             }
             
                  // set the zero missing to the product
                  for( int b = 0; b <transforSize; b++)
                  {
                  
          difference.add(0);
                  }
                  
                  // adding the missing zero to the product.
                  for (int c = length, i = 0; c < transforSize && i < isNotBigger.size(); i++,c++ )
                  {
                  
                  difference.set(c, isNotBigger.get(i));
                   
                  }
                     
                  // length is the number of zero missing to the answer
                  int missingZero = difference.size() - isNotBigger.size();
                  
                  isNotBigger.clear();
                  
                  boolean isBigg = isGreaterThan(transformer, difference);
                  
                  boolean sameThing = transformer.equals(difference);
                  
                  // if there is no zero missing
                  if(missingZero == 0)
                  {
                  // if transformer is greater than difference or equals difference
                   if(isBigg == true || sameThing == true)
                    {   
                     answer = result;
                     
                   //do the addition whenever firstArray Size is greater than secondArray
                     if(firstArray.size() > secondArray.size())  
                    {
                           myQuotien.add(answer);
                           myQuo = addArray(myQuo, myQuotien);
                           myQuotien.clear();
                           transformer = subtractArray(transformer, difference);
                    }
                    else if(firstArray.size() == secondArray.size())
                    {// firstArray and secondArray have the same size use the add method with myQuo
                           myQuotien.add(answer);
                           myQuo.add(answer);
                           myQuotien.clear();
                           transformer = subtractArray(transformer, difference);  
                    }
                    else
                    {// nothing to do
                     
                    }
                    
                    }
                   // the difference is greater than transformer( the result might absolutely minus one unit)
                    else
                    {
                     // correct result and empty variables to re-do the operation
                     result = result-1;    
                     answer = result;
                     myAnswer.clear();
                     difference.clear();
                     
                    //do the addition whenever firstArray Size is greater than secondArray
                     if(firstArray.size() > secondArray.size())  
                    {
                           myQuotien.add(answer);
                           myQuo = addArray(myQuo, myQuotien);
                           myQuotien.clear();
                           transformer = subtractArray(transformer, difference);
                    }
                    else if(firstArray.size() == secondArray.size())
                    {// firstArray and secondArray have the same size use the add method with myQuo
                           myQuotien.add(answer);
                           myQuo.add(answer);
                           myQuotien.clear();
                           transformer = subtractArray(transformer, difference);  
                    }
                    else
                    {
                     // nothing to do
                    }
                    
                     
                    myAnswer.add(answer);
                    isNotBigger = multiplied(secondArray, myAnswer);
                    myAnswer.clear();
                       
                       length = transformer.size()-isNotBigger.size();
                       
                       for( int b = 0; b <transforSize; b++)
                       {
                       
                   difference.add(0);
                       }
                       
                       for (int c = length, i = 0; c < transforSize && i < isNotBigger.size(); i++,c++ )
                       {
                       
                       difference.set(c, isNotBigger.get(i));
                        
                       }
                       
                    isNotBigger.clear();
                     
                       transformer = subtractArray(transformer, difference);
                     
                     }
                   
                   
                  }
                  else// firstArraySize is greater than secondArray Size, you would add some zero to the result
                  {
                  
                   // whenever transformer is greater than difference or equals to difference
                  if(isBigg == true || sameThing == true)
                     {  
                    answer = result;
                    
                   //do the addition whenever firstArray Size is greater than secondArray
                        if(firstArray.size() > secondArray.size())  
                   {
                            // put zero
                         for (int b = missingZero; b>0; b--)
                         {
                          myQuotien.add(0);
                          
                         }
                           // then add myQuotien to final result (myQuo)
                        myQuotien.add(answer);
                          myQuo = addArray(myQuo, myQuotien);
                          myQuotien.clear();
                          transformer = subtractArray(transformer, difference);
                   }
                       // otherwise firstArray and secondArray have the same size use the add method with myQuo
                   else if(firstArray.size() == secondArray.size())
                   {
                   
                          myQuotien.add(answer);
                          myQuo.add(answer);
                          myQuotien.clear();
                          transformer = subtractArray(transformer, difference);  
                   }
                   else
                   {
                    // do not do anything
                   }
                     }
                     else // difference is greater than transformer
                     {
                      
                      
                      result = result-1;
                     
                      
                      /*if ( result == 0 || transformer.size() < secondArray.size())
                         {
                          myQuotien.add(result);
                          myQuo = addArray(myQuo, myQuotien);
                          break;
                         }*/
                      
                      answer = result;
                      
                      myAnswer.clear();
                      difference.clear();
                      
                      myAnswer.add(answer);
                     
                      
                     if(firstArray.size() > secondArray.size())  
                  {
                           // put zero
                        for (int b = missingZero; b>0; b--)
                            {
                              myQuotien.add(0);
                         
                            }
                          // then add myQuotien to final result (myQuo)
                       myQuotien.add(answer);
                         myQuo = addArray(myQuo, myQuotien);
                         myQuotien.clear();
                         transformer = subtractArray(transformer, difference);
                  }
                      // otherwise firstArray and secondArray have the same size use the add method with myQuo
                  else if(firstArray.size() == secondArray.size())
                  {
                  
                         myQuotien.add(answer);
                         myQuo.add(answer);
                         myQuotien.clear();
                         transformer = subtractArray(transformer, difference);  
                  }
                  else
                  {
                   // do not do anything
                  }
                      
                      
                      isNotBigger = multiplied(secondArray, myAnswer);
                        
                        length = transformer.size()-isNotBigger.size();
                        
                        for( int b = 0; b <transforSize; b++)
                        {
                        
                    difference.add(0);
                        }
                        
                        for (int c = length, i = 0; c < transforSize && i < isNotBigger.size(); i++,c++ )
                        {
                        
                        difference.set(c, isNotBigger.get(i));
                         
                        }
                        
                      isNotBigger.clear();
                      
                        transformer = subtractArray(transformer, difference);
                      
                     }
                  
                  
                     // myQuo = reverseArray(myQuo);
                  ////// addition in the new ArrayList.
                  }
                   
            } 
            //Whenever transformer is inferior to the product of secondArray times " possible result".
            else 
            {
            boolean isGood = isGreaterThan(isNotBigger, transformer);
             
              answer = result;
              do{
                  myAnswer.clear();
               answer = answer -1;
               myAnswer.add(answer);
               isNotBigger = multiplied(secondArray, myAnswer);
               isGood = isGreaterThan(isNotBigger, transformer);
               transformer = subtractArray(transformer, isNotBigger);
               isNotBigger.clear();
             }
             while(isGood == true);
             
            myQuo = addArray(myQuo,myAnswer); 
            
             
            }
              
        
       }
       else
       {
       answer = 0; 
       myQuotien.add(answer);
       myQuo.add(answer);
       
       }
      
        myQuotien.clear();
        myAnswer.clear();
        keepGoing = isGreaterThan(transformer, secondArray); 
      } 
     while(keepGoing == true); 
          
         
       return myQuo;
  }  
    
    
     public ArrayList <Integer> reverseArray(ArrayList<Integer> myArray)
     {
         ArrayList <Integer> tempa = new ArrayList <Integer>();
         
         for(int a = myArray.size()-1; a >= 0; a --)
         {
          tempa.add(myArray.get(a));
         }
         
      return tempa;
     }
     
     public BigInt modulus(BigInt otherObjt)
     {
      BigInt modulus = new BigInt();
      
      modulus.numerical = module(this.numerical, otherObjt.numerical);
      
         return modulus;
     }
     // Modulus
     private ArrayList<Integer> module( ArrayList <Integer> array1, ArrayList <Integer> array2)
     {
      ArrayList <Integer> remainder = new ArrayList <Integer>();
      ArrayList <Integer> quotien = new ArrayList <Integer>();
      ArrayList <Integer> product = new ArrayList <Integer>();
      try{
       
       quotien = divideArray(array1, array2);
       
       product = multiplied (quotien, array2);
       
       remainder = subtractArray(array1, product);
       
      } 
      catch(InputMismatchException e)
      {
       
      }
      
      return remainder;
     }
     // reverse the array
     private String reverseThat(ArrayList<Integer> toReverse)
     {   
      String myAnswer = "";
      
      for(int i = toReverse.size()-1; i>=0; i--)
      {
       Integer s1 = toReverse.get(i);
       myAnswer = myAnswer+ s1;
      }
      return myAnswer;
     }
     //check zero
     private ArrayList <Integer> checkZero(ArrayList<Integer> array)
     {
      ArrayList <Integer> voidZero = new ArrayList<Integer>();
         
      String myStrArray = reverseThat(array);
      
      int length = myStrArray.length();
      
      for (int i = 0; i < length; i++)
      {
       if(myStrArray.charAt(0)== '0')
       {
         if(myStrArray.length()==1)
         {
        	 myStrArray = ""+ myStrArray;
         }
         else
         {
        	 myStrArray = myStrArray.substring(1);
         }
       }
       else
       {
        break;
       }
      }
      
      try{
       int n =0;
        for (int i = myStrArray.length()-1; i>=0; i-- )
        {   
           boolean l = Character.isDigit(myStrArray.charAt(i));
        
             if(l == true)
             {
            	 
              Character c = new Character (myStrArray.charAt(i));
              String s = c.toString(); 
              n = Integer.parseInt(s);
             }
             else
             {
              System.exit(0);
             }
             
           voidZero.add(n);
       }
       
        }
        catch(InputMismatchException e)
        {
         System.out.println("invalid entry!");
         System.exit(0);
        }
        
      
     
    
      return voidZero;
     }
 // to print result    
     public String toString()
  {
      String answer = "";
   
      answer = this.reverseThat(numerical);
   
   if(negative == true)
   {  
      if("0".equals(reverseThat(numerical)))
      {  
       answer = this.reverseThat(numerical);
      }
      else{answer = "-"+this.reverseThat(numerical);}
   }
   else
         {  
    answer = this.reverseThat(numerical);;
      }
         
  return answer; 
   
  }
    
}
 
 
