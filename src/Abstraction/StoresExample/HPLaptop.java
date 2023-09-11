package Abstraction.StoresExample;

public class HPLaptop extends Product{

    public HPLaptop(String type, String desc, int price) {
        super(type, desc, price);
    }

    @Override
    void showDetails() {
        System.out.println(name + "laptop");
        System.out.println("Amazing performance");
    }
}
