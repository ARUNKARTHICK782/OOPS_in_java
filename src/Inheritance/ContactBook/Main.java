package Inheritance.ContactBook;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static void displayStorageMenu(){
        System.out.println("Select from below : ");
        System.out.println("1.Google Account\n2.Device");
    }


    public static void main(String[] args) {
        while(true){
            displayStorageMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{
                    GoogleContactBook.main(new String[]{});
                    break;
                }
                case 2:{
                    ContactBook.main(new String[]{});
                    break;
                }
            }

        }
    }



}
