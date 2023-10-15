
public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("EE123456789101213141", 1000, 2, 5);
        System.out.println(savingsAccount);
        savingsAccount.deposit(300);
        savingsAccount.withdraw(150);
        System.out.printf("\nYou get extras in the end of saving period " + savingsAccount.calculateToRate());
        System.out.println(" \n");
        CheckingAccount checkingAccount = new CheckingAccount("EE123456789101213141", 1500, 400);
        System.out.println(checkingAccount);
        checkingAccount.deposit(500);
        checkingAccount.withdraw(50);
        checkingAccount.calculateToRate();

        System.out.println(" ");
        CreditAccount creditAccount = new CreditAccount("EE123456789101213141", 5000, 1.5, 9, 2500);
        System.out.println(creditAccount);
        creditAccount.deposit(300);
        creditAccount.withdraw(500);
        System.out.printf("\nYou need to return extras " + creditAccount.calculateToRate() + creditAccount.getPeriodOfLoan());

    }
}
