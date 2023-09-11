package InterfacesExample.FunctionalInterface;

public class Main {
    public static void main(String[] args) {
        Add add = (a, b) -> {
            if(a+b>50)
                return a+b;
            return -1;
        };

        System.out.println(add.addTwoNumbers(2,3));
    }

}
