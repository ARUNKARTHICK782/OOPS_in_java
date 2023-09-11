package InterfacesExample.Interface;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Face implements Biometric{

    @Override
    public boolean verify() {
        System.out.println("Verifying using face biometrics");
        return false;
    }

    @Override
    public void createUser() {

        //If we want to use their implementation of the newly added function we can use super keyword to achieve this
//        Biometric.super.createUserUsingAadhaar("asdf");


        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new user name : ");
        name = scanner.nextLine();

        Map<String,String> userDetails = new HashMap<>();
        userDetails.put("name",name);

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG images only allowed","jpg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            userDetails.put("data",chooser.getSelectedFile().getName());
            try{
                FileWriter fileWriter = new FileWriter("facedata.txt",true);
                fileWriter.write(userDetails.toString());
                System.out.println("Face data added");
                fileWriter.close();
            }
            catch (Exception e){
                System.out.println("Error while creating user face data");
            }
        }
    }

    @Override
    public void createUserUsingAadhaar(String aadhaarId){
        System.out.println("Face biometric's own implementation of the newly added function");
    }

}