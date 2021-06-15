public class BankAccount {
    private int ID;
    private double balance;
    private double interestRate;
    public static double interest = 0.2;
    public static int IdCounter=0;


    public BankAccount() {
        this.ID = IdCounter++;
        this.balance = 0;
        this.interestRate = interest;
    }

    public void setInterest(double interestRate) {
        BankAccount.interest = interestRate;
    }

    public double getInterestRate() {
        return this.balance*=interest;
    }

    public void deposit(double money) {
        this.balance += money;
    }


}
