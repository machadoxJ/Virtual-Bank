package model.data;

public class Bank {

    private static Double balance = 0.00;

    private static Double amount = 0.00;

    public Bank() {}

    //Balance Add/Remove/Check/Set

    public static double getBalance() { return balance; }

    public void setBalance(double balance) {
        Bank.balance = balance;
    }

    public void deposit(double deposit) {
        balance += deposit;
    }

    public void withdraw(double withdraw) {
        balance -= withdraw;
    }

    public void tax(double transfer) {
        if (transfer <= 100.0) {
            amount = transfer * 0.0038;
        }
        else {
            amount = transfer * 0.005;
        }
    }

    public static double getTax() { return amount;}

    //Account Check/Set/Activate

    public static Boolean getaccount() {
        return account;
    }

    public void setAccount(Boolean account) {
        Bank.account = account;
    }

    public static Boolean account = true;
}
