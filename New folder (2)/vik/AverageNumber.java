package Inheritance;


class CountIsZeroException extends Exception {

	public CountIsZeroException(String message) {
		super(message);
	}
}
public class AverageNumber {
	
	public static void calculatingAverage(int... num) throws CountIsZeroException  {
		int count=0,sum=0;
		for(int x : num) {
			count++;
			sum+=x;
		}
		
		if(count==0){
			throw new CountIsZeroException("You have not entered any element");
		}else {
			double average=(double)sum/(double)count;
		System.out.println("The count of entered element is :"+count+" and the sum of all the element is : "+sum+" whose average is :"+average);
		}
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		try {
			AverageNumber.calculatingAverage(3,4,5);
			AverageNumber.calculatingAverage(3,4,5,6);
			AverageNumber.calculatingAverage();
			
		} catch (CountIsZeroException e) {
			
			System.out.println(e);
		}catch(ArithmeticException e) {
			System.out.println(e);
		}
	}

}

