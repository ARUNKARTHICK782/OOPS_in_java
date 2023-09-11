package Abstraction.StoresExample;

public abstract class Product {
    protected String name;
    protected String desc;
    protected int price;

    public Product(String name, String desc, int price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    void printProductDetails(){
        System.out.println("Product Name : "+name);
        System.out.println("Product Price : "+price);
        System.out.println("Product Description : "+desc);
    }

    int calculateTotalPrice(int quantity){
        return quantity*price;
    }

    abstract void showDetails();
}
