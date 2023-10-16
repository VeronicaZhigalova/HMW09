public abstract class AbstractBankAccount {

    public String accountNumber;
    public double balance;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber.length() == 20) {
            this.accountNumber = accountNumber;
        } else {
            throw new IllegalArgumentException("Account length is not correct");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance can't be negative");
        }
    }


    public AbstractBankAccount(String accountNumber, double balance) {
        setAccountNumber(accountNumber);
        setBalance(balance);
    }


    public abstract double calculateToRate();


    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposit:" + amount + ", Current balance :" + getBalance());
    }

    public void withdraw(double amount) {
        if (getBalance() - amount > 0) {
            setBalance(getBalance() - amount);
        } else {
            throw new RuntimeException("You don't have enough money");
        }
        System.out.println("Withdraw:" + amount + ", Current balance :" + getBalance());
    }
}
