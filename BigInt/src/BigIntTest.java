
public class BigIntTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigInt numb1 = new BigInt("897446455");
		
		BigInt numb2 = new BigInt("200000000");
		
		BigInt result = null;
		
	    result = numb1.modulus(numb2);
	   
	   System.out.println(result.toString());
		
		

	}

}
