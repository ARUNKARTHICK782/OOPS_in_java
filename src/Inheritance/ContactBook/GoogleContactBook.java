package Inheritance.ContactBook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GoogleContactBook extends ContactBook{
    private static ArrayList<Contact> googleContacts;
    static Scanner scanner = new Scanner(System.in);
    GoogleContactBook(){
        googleContacts = new ArrayList<>();
    }

    @Override
    void addContact(Contact contact) {
        googleContacts.add(contact);
    }

    void syncWithGoogleAccount(){
        System.out.println("Fetching all contacts");
        ArrayList<Contact> uniqueContacts = new ArrayList<>();
        ArrayList<String> uniquePhno = new ArrayList<>();
        for(var contact:googleContacts){
            uniqueContacts.add(contact);
            uniquePhno.add(contact.getPhNo());
        }

        for(var contact:getAllContacts()){
            if(!uniquePhno.contains(contact.getPhNo())){
                uniqueContacts.add(contact);
            }
        }
        googleContacts = uniqueContacts;
        System.out.println("Synced contacts");
    }

    void showGoogleContacts(){
        System.out.println(googleContacts);
    }

    void showAllContacts(){
        for(var contact:googleContacts){
            if(!contact.isBlocked()){
                System.out.println(contact);
            }
        }
        for(var contact:getAllContacts()){
            if(!contact.isBlocked()){
                System.out.println(contact);
            }
        }
    }

    static void displayFunctions(){
        System.out.println("Select from below : ");
        System.out.println("\n" +
                "1.Add contact\n" +
                "2.Remove contact\n" +
                "3.Sync contacts from phone\n" +
                "4.Show google contacts\n" +
                "5.Show all contacts\n" +
                "0.Exit");
    }

    public static void main(String[] args) {

        GoogleContactBook googleContactBook = new GoogleContactBook();
        int choice;
        boolean exitGoogleContacts = false;
        while (!exitGoogleContacts){
            displayFunctions();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:{
                    exitGoogleContacts = true;
                    break;
                }
                case 1:{
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone no : ");
                    String phno = scanner.nextLine();
                    System.out.println("Enter email : ");
                    String email =scanner.nextLine();
                    googleContactBook.addContact(new Contact(name,phno,email));
                    System.out.println("Added to google contacts");
                    break;
                }
                case 2:{
                    System.out.println("Enter phone no : ");
                    String phno = scanner.nextLine();
                    for(int contactCounter=0;contactCounter<=googleContacts.size();contactCounter++){
                        if(googleContacts.get(contactCounter).getPhNo().equals(phno)){
                            googleContacts.remove(contactCounter);
                            break;
                        }
                    }
                    System.out.println("Removed from google contacts");
                    break;
                }
                case 3:{
                    System.out.println("Syncing phone contacts with google contacts");
                    googleContactBook.syncWithGoogleAccount();
                    break;
                }
                case 4:{
                    googleContactBook.showGoogleContacts();
                    break;
                }
                case 5:{
                    googleContactBook.showAllContacts();
                    break;
                }
            }
        }

    }
}
