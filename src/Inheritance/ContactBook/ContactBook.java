package Inheritance.ContactBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactBook {
    static ArrayList<Contact> contactList = new ArrayList<>();
    static ArrayList<Contact> favourites = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    void addContact(Contact contact){
        contactList.add(contact);
    }

    void removeContact(String phNo){
        for(int contactCounter = 0;contactCounter<=contactList.size();contactCounter++){
            if(contactList.get(contactCounter).getPhNo().equals(phNo)){
                contactList.remove(contactCounter);
                break;
            }
        }
    }

    void addToFavourites(Contact contact){
        favourites.add(contact);
    }

    ArrayList<Contact> getAllContacts(){
        return contactList;
    }

    ArrayList<Contact> getAllFavourites(){
        return favourites;
    }

    void blockContact(Contact contact){
        for(int contactCounter = 0;contactCounter<=contactList.size();contactCounter++){
            if(contactList.get(contactCounter).getPhNo().equals(contact.getPhNo())){
                contactList.get(contactCounter).setBlocked(true);
                break;
            }
        }
    }

    void showContacts(){
        System.out.println(contactList);
    }

    static void displayFunctions(){
        System.out.println("Select from below : ");
        System.out.println("\n" +
                "1.Add contact\n" +
                "2.Remove contact\n" +
                "3.Show all contacts\n" +
                "0.Exit");
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        int choice;
        boolean exitContactBook = false;
        while (!exitContactBook){
            displayFunctions();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:{
                    exitContactBook = true;
                    break;
                }
                case 1:{
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone no : ");
                    String phno = scanner.nextLine();
                    System.out.println("Enter email : ");
                    String email =scanner.nextLine();
                    contactBook.addContact(new Contact(name,phno,email));
                    System.out.println("Added to contact book");
                    break;
                }
                case 2:{
                    System.out.println("Enter phone number to remove : ");
                    String phNo = scanner.nextLine();
                    contactBook.removeContact(phNo);
                    System.out.println("Removed from contact book");
                    break;
                }
                case 3:{
                    contactBook.showContacts();
                    break;
                }
            }
        }
    }
}
