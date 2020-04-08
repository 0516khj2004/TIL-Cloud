package workshop.account.test;


import workshop.account.entity.Account;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account account = new Account("A1100", "221-22-34", 10000);
		
		System.out.println(account);
		
		account.deposisite(10000);
		
		System.out.println(account.getBalance());
		
		account.withdraw(20000);
		
		System.out.println(account.getBalance());
	}

}