public class SavingsAccount extends AbstractBankAccount {

    private double percentage;
    private int periodOfMonths;

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        if (percentage > 0 && percentage < 100) {
            this.percentage = percentage;
        } else {
            throw new IllegalArgumentException("Rate of percent is not correct");
        }
    }

    public int getPeriodOfMonths() {
        return periodOfMonths;
    }

    public void setPeriodOfMonths(int periodOfMonths) {
        if (periodOfMonths > 0) {
            this.periodOfMonths = periodOfMonths;
        } else {
            throw new IllegalArgumentException("Period of months is not correct");
        }
    }

    public SavingsAccount(String accountNumber, double balance, double percentage, int periodOfMonths) {
        super(accountNumber, balance);
        setPercentage(percentage);
        setPeriodOfMonths(periodOfMonths);
    }

    @Override
    public double calculateToRate() {
        try {
            double interestIncome = (percentage / 12) / 100 * periodOfMonths * getBalance();
            System.out.printf("Saving period is:" + periodOfMonths + ", your current balance: " + getBalance());
            return interestIncome;

        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }

    }
}