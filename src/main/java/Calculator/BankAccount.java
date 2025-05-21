package Calculator;


public class BankAccount {
	 private String owner;
	 private double balance;
	 
	 public BankAccount(String owner, double initialBalance) {
		 if (initialBalance < 0) {
			 throw new IllegalArgumentException("Balance initial ne peux pas être négative.");
		 }
		 
		 this.owner = owner;
		 this.balance = initialBalance;
	 }
	 
	 public double getBalance() {
		 return balance;
	 }
	 
	 public String getOwner() {
		 return owner;
	 }
	 
	 public void deposit(double amount) {
		 if (amount <= 0) {
			 throw new IllegalArgumentException("montant doit être positif");
		 }
		 balance += amount;
	 }
	 
	 public void withdraw(double amount) {
		 if (amount <= 0) {
			 throw new IllegalArgumentException("montant doit être positif");
		 }
		 if (amount > balance) {
			 throw new IllegalArgumentException("Fond insufisant .");
		 }
		 balance -= amount;
		 }
	}