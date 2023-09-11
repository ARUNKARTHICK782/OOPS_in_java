package Abstraction.StoresExample;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void addProducts(){
        products.add(new Book("The other side of me","Autobiography",450));
        products.add(new HPLaptop("Pavilion","Updated",60000));
        products.add(new DialogWatch("Watch","Retro Styled watch",850));
    }

    static void showProducts(){
        int ctr = 1;
        for(var product:products) {
            System.out.println("S.No : "+(ctr++));
            System.out.println("Name : " + product.name);
            System.out.println("Desc : " + product.desc);
            System.out.println("Price : " + product.price);
        }
    }

    static void printOrder(){
        System.out.println("Order details");
        for(var order : orders){
            order.product.printProductDetails();
            System.out.println("Total Price : "+order.product.calculateTotalPrice(order.quantity));
            System.out.println("----".repeat(30));
        }
    }

    public static void main(String[] args) {
        addProducts();
        while (true){
            System.out.println("Choose from the below options");
            System.out.println("1. Show Products\n2. Add an item to cart\n3. Show orders");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case -1:{
                    System.exit(1);
                    break;
                }
                case 1:{
                    showProducts();
                    break;
                }
                case 2:{
                    System.out.println("Enter product serial no : ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter quantity");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    orders.add(new Order(quantity,products.get(productId-1)));
                    break;
                }
                case 3:{
                    printOrder();
                    break;
                }
                default:{
                    System.exit(1);
                }
            }


        }

    }
}
