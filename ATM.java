import java.util.Scanner;
import java.util.ArrayList;
public class ATM{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int StoredPin = 9999;
        double balance = 2000;

        //create the arraylist to view transaction history
        ArrayList<String> transactions = new ArrayList<>();

        System.out.print("Enter the 4 digit pin:");
        int EnteredPin = scanner.nextInt();

        if (EnteredPin != StoredPin){
            System.out.println("Invalid Pin!......Please Try Again.");


        }else{

            int choice;
            do{
                System.out.println("===========ATM MENU===========");
                System.out.println("1. Check balance");
                System.out.println("2. Deposit Amount");
                System.out.println("3. Withdraw Amount");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");
                System.out.println("Enter the choice from (1-5):");
                choice = scanner.nextInt();

                switch (choice){
                    case 1:
                    System.out.println("Your current balance is: " + balance);
                    break;

                    case 2:
                    System.out.print("Enter amount to deposit:");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0){
                        balance += deposit;
                        String record = "Deposied " + deposit + "AED";
                        transactions.add(record);
                        System.out.println(record);
                    }else{
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                    case 3:
                    System.out.print("Enter amount to withdraw:");
                    double withdraw = scanner.nextDouble();
                    if (withdraw > 0 && withdraw <= balance){
                        balance -= withdraw;
                        String record = "Withdraw " + withdraw + "AED";
                        transactions.add(record);
                        System.out.println(record);
                    }else{
                        System.out.println("Invalid withdrawal amount!");
                    }
                    break;

                    case 4:
                    System.out.println("Transcations History...");
                    if (transactions.isEmpty()){
                        System.out.println("No transactions found...");
                    }else{
                        for (String T: transactions){
                            System.out.println(" - " + T);
                        }
                    }
                    break;

                    case 5:
                    System.out.println("Exiting the menu....GoodBye!");
                    break;

                    default:
                    System.out.println("Invalid choice....Please try again!!");
                }
            }while(choice != 5);
        }
        scanner.close();
    }
    
}