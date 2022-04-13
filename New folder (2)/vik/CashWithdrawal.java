package Inheritance;

import java.util.Scanner;

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

public class CashWithdrawal {
	static int balance = 8000;

	public static void checkBalance(int amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient Balance");
		} else {
			balance -= amount;

			System.out.println("Please collect your cash! Remaining amount : " + balance);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter withdrawal amount:");
		int amount = scanner.nextInt();
		scanner.close();

		try {
			CashWithdrawal.checkBalance(amount);
		} catch (InsufficientBalanceException e) {
			System.out.println(e);
		}

	}

}
