public class CheckingAccount extends AbstractBankAccount {

    private double withdraw;

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        if (withdraw > 0) {
            this.withdraw = withdraw;
        } else {
            throw new RuntimeException("Withdrawals is not correct");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount < getWithdraw() && getBalance() - amount > 0) {
            setBalance(getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Withdrawals is impossible, you don't have enough money");
        }
        System.out.println("Withdraw:" + amount + ", Current balance: " + getBalance());
    }


    public CheckingAccount(String accountNumber, double balance, double withdraw) {
        super(accountNumber, balance);
        setWithdraw(withdraw);
    }

    @Override
    public double calculateToRate() {
        System.out.println("Rate for this account is not exist");
        return 0;


    }
}