package Abstraction.StoresExample;

public class Book extends Product{

    public Book(String name, String desc, int price) {
        super(name, desc, price);
    }

    @Override
    void showDetails() {
        System.out.println(name+" is a best seller book in 2022");
        System.out.println("Price : "+price);
    }
}
