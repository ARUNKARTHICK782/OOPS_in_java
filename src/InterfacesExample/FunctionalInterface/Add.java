package InterfacesExample.FunctionalInterface;

@FunctionalInterface
interface Add {
    int addTwoNumbers(int a, int b);
    default void sampleDefaultMethod(){
        System.out.println("Default Methods");
    }
    static void sampleStaticMethod(){
        System.out.println("Static method");
    }
}
