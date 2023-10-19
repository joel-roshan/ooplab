import java.util.ArrayList;

class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " into account #" + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from account #" + accountNumber);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    @Override
    public String toString() {
        return "Account #" + accountNumber + " (Holder: " + accountHolder + ", Balance: $" + balance + ")";
    }
}

class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(int accountNumber, String accountHolder, double initialBalance) {
        Account account = new Account(accountNumber, accountHolder, initialBalance);
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    public void removeAccount(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account removed: " + account);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAllAccounts() {
        System.out.println("All Accounts in the Bank:");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

public class BankAccountProgram {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(101, "Alice", 1000);
        bank.addAccount(102, "Bob", 1500);
        bank.addAccount(103, "Charlie", 500);

        bank.displayAllAccounts();

        bank.deposit(101, 200);
        bank.withdraw(102, 300);

        bank.displayAllAccounts();

        bank.removeAccount(103);

        bank.displayAllAccounts();
    }
}
