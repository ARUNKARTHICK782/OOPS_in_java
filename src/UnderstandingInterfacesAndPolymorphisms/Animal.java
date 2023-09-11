package UnderstandingInterfacesAndPolymorphisms;

import java.util.ArrayList;
import java.util.Objects;

//public class Animal {
//
//    ArrayList<Animal> animals = new ArrayList<>();
//
//    void addAnimal(Animal animal){
//        animals.add(animal);
//    }
//
//    void showAnimals(){
//        System.out.println(animals);
//    }
//}
//
//class Dog extends Animal{
//
//}
//
//class Cat extends Animal{
//
//}
//
//class Main{
//    public static void main(String[] args) {
//        Animal animal = new Animal();
//        animal.addAnimal(new Dog());
//        animal.addAnimal(new Cat());
//        animal.showAnimals();
//    }
//}


/*

By using the above Animal class i can add any object which is an animal but when we are creating any data structure
the incoming object will not be Animal type they can be anything and we know that every object in java extends Object
class So lets see what happens when we create an arraylist of type Object in animal class.

*/


//class CustomDataStructure{
//    ArrayList<Object> list = new ArrayList<>();
//
//    void addToList(Object object){
//        list.add(object);
//    }
//
//    ArrayList<Object> showList(){
//        return list;
//    }
//}
//
//
//class Dog{
//
//}
//
//class Cat{
//
//}
//
//class Car{
//
//}
//
//class Main{
//    public static void main(String[] args) {
//        CustomDataStructure customDataStructure = new CustomDataStructure();
//        customDataStructure.addToList(new Dog());
//        customDataStructure.addToList(new Car());
//        // This is possible because Object type can be assigned to Object
//        Object dog = customDataStructure.showList().get(0);
//
//        // This is not possible because Object type cannot be assigned to Car type
////        Car car = customDataStructure.showList().get(1);
//
//    }
//}

abstract class Animal{
    abstract void makeNoise();
    abstract void run();
}


class Pet extends Animal{
    public void makeNoise(){

    }

    public void run(){

    }

}

class Dog extends Pet{
    int height = 0;
    public void run(){

    }
}
