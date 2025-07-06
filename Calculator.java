import java.util.Scanner;
public class Calculator {
    public static void main(String[]args){
        Scanner calc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("CALCULATOR MENU");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Choose the operator (1-5)");
            choice = calc.nextInt();

            if (choice >= 1 && choice <= 4){
                System.out.println("Enter the first number: ");
                double num1 = calc.nextDouble();

                System.out.println("Enter the second number: ");
                double num2 = calc.nextDouble();

                double result = 0;

                switch (choice){
                    case 1:
                    result = num1 + num2;
                    System.out.println("Result of " + num1 + " and " + num2 + " is: " + result);
                    break;

                    case 2:
                    result = num1 - num2;
                    System.out.println("Result of " + num1 + " and " + num2 + " is: " + result);
                    break;

                    case 3:
                    result = num1 * num2;
                    System.out.println("Result of " + num1 + " and " + num2 + " is: " + result);
                    break;

                    case 4:
                    if (num2 != 0){
                        result = num1/num2;
                        System.out.println("result of " + num1 + " and " + num2 + " is: " + result);
                        
                    }else{
                        System.out.println("Cannot divide by zero!");
                    }

                }
            }else if (choice != 5){
                System.out.println("Invalid option.. Please try again!!");
            }else {
                System.out.println("Exiting the calculator");
            }
        }while (choice!=5);

        calc.close();
    }
    
}
