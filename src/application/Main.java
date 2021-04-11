package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.PersonalException;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Inicial Balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			Double withdraLimit = sc.nextDouble();
			Account account = new Account(number, holder, balance, withdraLimit);		
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.printf("New balance: %.2f", account.getBalance());
			
		}
		catch(PersonalException e) {
			System.out.print("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected Error");
		}
		sc.close();
	}

}
