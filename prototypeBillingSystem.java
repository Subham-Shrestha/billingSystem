import java.util.ArrayList;
import java.util.Scanner;

public class prototypeBillingSystem {
    public static void main(String[] args) {
        Scanner takeInput = new Scanner(System.in);
        boolean quitOrNot = false;
        double sum = 0;
        double total;
        int VAT = 13;

        while (true) {
            System.out.println("Enter user ID (or 'quit' to exit): ");
            String userId = takeInput.nextLine();
            if (userId.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Enter password: ");
            String password = takeInput.nextLine();
            if (password.equalsIgnoreCase("quit")) {
                break;
            }
            System.out.println("Enter the number of items you want to buy : ");
            String itemString = takeInput.nextLine();
            if (itemString.equalsIgnoreCase("quit")) {
                return;
            }
            int itemNumber = Integer.parseInt(itemString);
            takeInput.nextLine();

            ArrayList<String> itemList = new ArrayList<>();
            ArrayList<Double> costItem = new ArrayList<>();
            for (int i = 0; i < itemNumber; i++) {
                System.out.print("Enter the name of item " + (i + 1) + ": ");
                String itemName = takeInput.nextLine();
                if (itemName.equalsIgnoreCase("quit")) {
                    break;
                }
                itemList.add(itemName);
            }
            System.out.println("   ");
            for (int i = 0; i < itemNumber ; i++){
                System.out.print("Enter the cost of item " + (i + 1) + ": ");
                double itemPrice = takeInput.nextDouble();
                costItem.add(itemPrice);
                sum += itemPrice;
                total = sum;
            }
            total = sum;
            System.out.println("The total cost is : " + sum);
            System.out.println("Shall we add VAT (y/n) : ");
            String checkYesNo = takeInput.next().toLowerCase();
            double costVat;
            if (checkYesNo.equalsIgnoreCase("y")) {
                costVat = total + (VAT / 100) * total;
                System.out.println("The total cost after VAT is : " + costVat);
            } else {
                costVat = total;
                System.out.println("The total cost is : " + costVat);
            }
            boolean validOrNot = false;
            double finalCost;
            while(validOrNot == false) {

                System.out.println("Enter the discount : ");
                Float discount = takeInput.nextFloat();
                if (discount > 60.00) {
                    System.out.println("The discount cannot be greater than 60 percent.");
                    validOrNot = false;
                } else {
                    validOrNot = true;
                    finalCost = costVat - (discount / 100) * costVat;
                    System.out.println("The final cost after the discount is  : " + finalCost);
                }
            }
            System.out.println("Enter the payment environment : ");
            String payEnvironment = takeInput.next();
            if (payEnvironment.equalsIgnoreCase("quit")) {
                break;
            }

            double note, div;
            System.out.println("Enter the amount you want to pay : ");
            note = takeInput.nextFloat();
            double exchange;
            exchange = note - costVat;

            System.out.println("The highest detomination are : ");
            if(exchange >= 1000){
                div = exchange / 1000;
                System.out.println("1000" + " X " + div);
                exchange = exchange % 1000;
            }
            if(exchange >= 500 && exchange <1000){
                div = exchange / 500;
                System.out.println("500" + " X " + div);
                exchange = exchange % 500;
            }
            if(exchange >= 100 && exchange < 500){
                div = exchange / 100;
                System.out.println("100" + " X " + div);
                exchange = exchange % 100;
            }
            if(exchange >= 50 && exchange < 100){
                div = exchange / 50;
                System.out.println("50" + " X " + div);
                exchange = exchange % 50;
            }
            if(exchange >= 20 && exchange < 50){
                div = exchange / 20;
                System.out.println("20" + " X " + div);
                exchange = exchange % 20;
            }
            if(exchange >= 10 && exchange < 20){
                div = exchange / 10;
                System.out.println("10" + " X " + div);
                exchange = exchange % 10;
            }
            if(exchange >= 5 && exchange < 10){
                div = exchange / 5;
                System.out.println("5" + " X " + div);
                exchange = exchange % 5;
            }
            if(exchange >=1 && exchange <5){
                div = exchange / 1;
                System.out.println("1" + " X " + div);
            }
            System.out.println("Do you want to quit or buy something else ? (y/n)");
            String quitOrNott = takeInput.next();
            if (quitOrNott.equalsIgnoreCase("y")) {
                break;
            }else{
                quitOrNot = true;
            }
        }

    }
}