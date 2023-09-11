package InterfacesExample.Interface;

import java.util.Arrays;
import java.util.List;

interface CircleInterface {
    List<String> allowedColors = Arrays.asList("RED", "GREEN", "BLUE");

    String getColor();

    default boolean isValid() {
        if (allowedColors.contains(getColor())) {
            return true;
        } else {
            return false;
        }
    }
}

class ChidlCircleInterfaceImpl implements CircleInterface {
    private String color;

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

abstract class Temp implements Biometric{
    abstract void func();
}

class arun extends Temp{
    Biometric biometric;
    void func(){

    }

    @Override
    public boolean verify() {
        return false;
    }

    @Override
    public void createUser() {

    }
}

public class Main {
    public static void main(String[] args) {

        ChidlCircleInterfaceImpl redCircleWithoutState = new ChidlCircleInterfaceImpl();
        redCircleWithoutState.setColor("RED");
        System.out.println(redCircleWithoutState.isValid());
//        Voice voice = new Voice();
//        voice.createUser();
//
//        Face face = new Face();
//        face.createUser();
    }
}