import java.util.Scanner;
public class UnitConverter {
    public static void main(String[]args){
        Scanner unit = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Unit Converter");
            System.out.println("1. Length (Meters to Feet)");
            System.out.println("2. Weight (Kilograms to pounds)");
            System.out.println("3. Tempersture (Celsius to Fahrenheit)");
            System.out.println("4. Exit");
            System.out.print("Choose a category (1-4)!");
            choice = unit.nextInt();


            switch (choice){
                case 1:
                System.out.println("Enter values in meters!");
                double meters = unit.nextDouble();
                double feet = meters * 3.28084;
                System.out.println(meters + " meters = " + feet + " feet");

                break;

                case 2:
                System.out.println("Enter values in kilograms!");
                double kg = unit.nextDouble();
                double pounds = kg * 2.20462;
                System.out.println(kg + " kg = " + pounds + "pounds");

                break;

                case 3:
                System.out.println("Enter values in celsius");
                double celsius = unit.nextDouble();
                double Fahrenheit = (celsius*9/5)+32;
                System.out.println(celsius + " celsius = " + Fahrenheit + "Fahrenheit");

                break;

                case 4:
                System.out.println("Exiting Unit Converter.. GoodBye!");
                break;

                default:
                System.out.println("Invalid option..Please try again!");

            }


        } while (choice != 4);

        unit.close();

    }
    
}
