// import java.util.ArrayList;

// class Account {
//     private int accountNumber;
//     private String accountHolder;
//     private double balance;

//     public Account(int accountNumber, String accountHolder, double balance) {
//         this.accountNumber = accountNumber;
//         this.accountHolder = accountHolder;
//         this.balance = balance;
//     }

//     public int getAccountNumber() {
//         return accountNumber;
//     }

//     public String getAccountHolder() {
//         return accountHolder;
//     }

//     public double getBalance() {
//         return balance;
//     }

//     public void deposit(double amount) {
//         if (amount > 0) {
//             balance += amount;
//             System.out.println("Deposited $" + amount + " into account #" + accountNumber);
//         } else {
//             System.out.println("Invalid deposit amount.");
//         }
//     }

//     public void withdraw(double amount) {
//         if (amount > 0 && amount <= balance) {
//             balance -= amount;
//             System.out.println("Withdrawn $" + amount + " from account #" + accountNumber);
//         } else {
//             System.out.println("Invalid withdrawal amount or insufficient balance.");
//         }
//     }

//     @Override
//     public String toString() {
//         return "Account #" + accountNumber + " (Holder: " + accountHolder + ", Balance: $" + balance + ")";
//     }
// }

// class Bank {
//     private ArrayList<Account> accounts;

//     public Bank() {
//         accounts = new ArrayList<>();
//     }

//     public void addAccount(int accountNumber, String accountHolder, double initialBalance) {
//         Account account = new Account(accountNumber, accountHolder, initialBalance);
//         accounts.add(account);
//         System.out.println("Account created: " + account);
//     }

//     public void removeAccount(int accountNumber) {
//         Account account = findAccount(accountNumber);
//         if (account != null) {
//             accounts.remove(account);
//             System.out.println("Account removed: " + account);
//         } else {
//             System.out.println("Account not found.");
//         }
//     }

//     public void deposit(int accountNumber, double amount) {
//         Account account = findAccount(accountNumber);
//         if (account != null) {
//             account.deposit(amount);
//         } else {
//             System.out.println("Account not found.");
//         }
//     }

//     public void withdraw(int accountNumber, double amount) {
//         Account account = findAccount(accountNumber);
//         if (account != null) {
//             account.withdraw(amount);
//         } else {
//             System.out.println("Account not found.");
//         }
//     }

//     public void displayAllAccounts() {
//         System.out.println("All Accounts in the Bank:");
//         for (Account account : accounts) {
//             System.out.println(account);
//         }
//     }

//     private Account findAccount(int accountNumber) {
//         for (Account account : accounts) {
//             if (account.getAccountNumber() == accountNumber) {
//                 return account;
//             }
//         }
//         return null;
//     }
// }

// public class BankAccountProgram {
//     public static void main(String[] args) {
//         Bank bank = new Bank();

//         bank.addAccount(101, "Alice", 1000);
//         bank.addAccount(102, "Bob", 1500);
//         bank.addAccount(103, "Charlie", 500);

//         bank.displayAllAccounts();

//         bank.deposit(101, 200);
//         bank.withdraw(102, 300);

//         bank.displayAllAccounts();

//         bank.removeAccount(103);

//         bank.displayAllAccounts();
//     }
// }


import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountInfo() {
        return "Account Number: " + accountNumber + "\nAccount Holder: " + accountHolder + "\nBalance: $" + balance;
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
        System.out.println("Account added successfully.");
    }

    public void removeAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                accounts.remove(account);
                System.out.println("Account removed successfully.");
                return;
            }
        }
        System.out.println("Account not found. Removal failed.");
    }

    public Account findAccount(int accountNumber) {
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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Show Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter Initial Balance: $");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    bank.addAccount(accountNumber, accountHolder, initialBalance);
                    break;

                case 2:
                    System.out.print("Enter Account Number to Remove: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bank.removeAccount(accountNumber);
                    break;

                case 3:
                    System.out.print("Enter Account Number to Deposit: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Account depositAccount = bank.findAccount(accountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter Deposit Amount: $");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number to Withdraw: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Account withdrawAccount = bank.findAccount(accountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter Withdrawal Amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        withdrawAccount.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number to Show Details: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Account accountDetails = bank.findAccount(accountNumber);
                    if (accountDetails != null) {
                        System.out.println(accountDetails.getAccountInfo());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
