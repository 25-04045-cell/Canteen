import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] foodItems = {
            "Burger",
            "Fries",
            "Spaghetti",
            "Chicken Sandwich",
            "Iced Tea"
        };

        double[] prices = {
            80.00,
            50.00,
            100.00,
            90.00,
            40.00
        };

        int totalQuantity = 0;
        double totalAmount = 0.00;

        char student;

        System.out.println("====================================");
        System.out.println("       CANTEEN ORDERING SYSTEM");
        System.out.println("====================================");

        System.out.println("\nMENU:");

        for (int i = 0; i < foodItems.length; i++) {
            System.out.printf("%d. %-20s PHP %.2f%n",
                    i + 1, foodItems[i], prices[i]);
        }

        System.out.print("\nAre you a student? (Y/N): ");
        student = Character.toUpperCase(input.next().charAt(0));

        while (student != 'Y' && student != 'N') {
            System.out.print("Invalid input. Please enter Y or N: ");
            student = Character.toUpperCase(input.next().charAt(0));
        }

        char orderAgain = 'Y';

        while (orderAgain == 'Y') {

            System.out.println("\n------------------------------------");

            System.out.print("Enter item number (1-5): ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            if (itemNumber < 1 || itemNumber > 5) {
                System.out.println(
                    "Invalid item number. Please try again."
                );
                continue;
            }

            if (quantity < 1 || quantity > 10) {
                System.out.println(
                    "Invalid quantity. Please enter 1 to 10."
                );
                continue;
            }

            double orderAmount =
                prices[itemNumber - 1] * quantity;

            totalQuantity += quantity;
            totalAmount += orderAmount;

            System.out.printf(
                "%s x%d = PHP %.2f%n",
                foodItems[itemNumber - 1],
                quantity,
                orderAmount
            );

            System.out.print(
                "Do you want to order again? (Y/N): "
            );

            orderAgain =
                Character.toUpperCase(input.next().charAt(0));

            while (orderAgain != 'Y' && orderAgain != 'N') {
                System.out.print(
                    "Invalid input. Please enter Y or N: "
                );

                orderAgain =
                    Character.toUpperCase(input.next().charAt(0));
            }
        }

        double discountRate;

        if (student == 'Y' && totalAmount >= 500) {
            discountRate = 0.15;
        }
        else if (student == 'Y') {
            discountRate = 0.10;
        }
        else if (totalAmount >= 500) {
            discountRate = 0.05;
        }
        else {
            discountRate = 0.00;
        }

        double totalDeduction =
            totalAmount * discountRate;

        double finalAmount =
            totalAmount - totalDeduction;

        System.out.println("\n====================================");
        System.out.println("           ORDER SUMMARY");
        System.out.println("====================================");

        System.out.println(
            "Total quantity of items purchased: "
            + totalQuantity
        );

        System.out.printf(
            "Total amount before deductions: PHP %.2f%n",
            totalAmount
        );

        System.out.printf(
            "Total deduction: PHP %.2f%n",
            totalDeduction
        );

        System.out.printf(
            "Final amount to pay: PHP %.2f%n",
            finalAmount
        );

        System.out.println("====================================");
        System.out.println("Thank you for ordering!");

        input.close();
    }
}