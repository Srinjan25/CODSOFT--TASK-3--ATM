import java.util.Scanner;

public class ATMsystem {
    private BankAccount userAccount;

    public ATMsystem(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void display() {
        System.out.println("Welcome to the ATM!");
        System.out.println("You have the following options :-");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            display();
            System.out.print("Select your preffered option: ");
            int yourchoice = scanner.nextInt();

            switch (yourchoice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    break;
                case 3:
                    System.out.println("Your balance is: " + userAccount.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option.\n Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0); // Initial balance
        ATMsystem atm = new ATMsystem(account);
        atm.run();
    }
}

