package Inheritance;

import java.util.Scanner;

class InvalidAgeException extends Exception {

	public InvalidAgeException(String message) {
		super(message);
	}
}

public class AgeVerification {
	
	public static void getAge(int age) throws InvalidAgeException {
		
		if(age<18) {
			throw new InvalidAgeException("You are not eligible to vote");
		}else if(age==18){
			System.out.println("Yes, Now you are eligible to vote!");
		}else {
			System.out.println("You are already eligible to vote");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter your age:");
		int age=scanner.nextInt();
		
		try {
			AgeVerification.getAge(age);
		} catch (InvalidAgeException e) {
			System.out.println(e);
		}

	}

}
