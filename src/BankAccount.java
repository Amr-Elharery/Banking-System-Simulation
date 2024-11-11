public class BankAccount {
    private double balance;


    public BankAccount(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    synchronized public void withdrew(double amount){
        if(amount <= this.balance) {
            this.balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew $" + amount + " | New balance: $" + this.balance);
        }
        else
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw $" + amount + " but has insufficient funds. Current balance: $" + this.balance);
    }

     synchronized public void deposit(double amount){
        this.balance += amount;
         System.out.println(Thread.currentThread().getName() + " deposited $" + amount + " | New balance: $" + this.balance);

    }
}
