package InterfacesExample.Interface;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Voice implements Biometric{

    private String generateVoiceData(){
        String data = "ABCDEFGHIJKLMNLOPQRSTUVWXYZ1234567890";
        StringBuffer hashedData = new StringBuffer();
        for(int ctr = 0; ctr<=100;ctr++){
            hashedData.append(data.charAt((int)(Math.random()*36)));
        }
        return hashedData.toString();
    }


    @Override
    public boolean verify() {
        System.out.println("Verifying using voice");
        return false;
    }

    @Override
    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new user name : ");
        String name = scanner.nextLine();
        try{
            FileWriter fileWriter = new FileWriter("voicedata.txt",true);
            Map<String,String> userData = new HashMap<>();
            userData.put("name",name);
            userData.put("data",generateVoiceData());
            fileWriter.write(userData.toString());
            fileWriter.close();
            System.out.println("User voice data saved");
        }
        catch (Exception e){
            System.out.println("Error while creating voice data");
        }
    }
}

