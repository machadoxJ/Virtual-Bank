package information;

public class BankInfo {

    public BankInfo() {

    }

    public static double getBalance() { return balance; }

    public void setBalance(double balance) {
        BankInfo.balance = balance;
    }

    public void add(double add) {
        balance += add;
    }

    public void withdraw(double withdraw) {
        balance -= withdraw;
    }

    public static Double balance = 0.00;

}
