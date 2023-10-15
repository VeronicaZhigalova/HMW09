public class CreditAccount extends AbstractBankAccount {

    private double percentage;
    private int periodOfLoan;
    private double creditLimit;

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        if (percentage > 0 && percentage < 100) {
            this.percentage = percentage;
        } else {
            throw new IllegalArgumentException("Percent is not correct");
        }
    }

    public int getPeriodOfLoan() {
        return periodOfLoan;
    }

    public void setPeriodOfLoan(int periodOfLoan) {
        if (periodOfLoan > 0) {
            this.periodOfLoan = periodOfLoan;
        } else {
            throw new RuntimeException("Wrong period");
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        if (creditLimit > 0) {
            this.creditLimit = creditLimit;
        } else {
            throw new IllegalArgumentException("Credit limit is not correct");
        }
    }

    public void withdraw(double amount) {
        double a = getBalance() - amount;
        if ((a < 0) && (Math.abs(a) <= creditLimit)) {
            setBalance(a);
            System.out.println("Withdrawal of:  " + amount + ", Current balance:" + getBalance());
        } else if (a > 0) {
            setBalance(a);
            System.out.println("Withdrawal of: " + amount + " , Current balance:" + getBalance());
        } else {
            throw new RuntimeException("Withdrawal is impossible");
        }
    }

    public CreditAccount(String accountNumber, double balance, double percentage, int periodOfLoan, double creditLimit) {
        super(accountNumber, balance);
        setPercentage(percentage);
        setPeriodOfLoan(periodOfLoan);
        setCreditLimit(creditLimit);
    }

    public double calculateToRate() {
        try {
            if ((getBalance() < 0 && Math.abs(getBalance()) <= creditLimit)) {
                return (percentage / 12) / 100 * periodOfLoan * Math.abs(getBalance());
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }

    }
}