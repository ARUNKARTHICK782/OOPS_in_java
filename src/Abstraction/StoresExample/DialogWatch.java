package Abstraction.StoresExample;

public class DialogWatch extends Product{

    public DialogWatch(String name, String desc, int price) {
        super(name, desc, price);
    }

    @Override
    void showDetails() {
        System.out.println("Retro styled watch worth "+price);
    }
}
