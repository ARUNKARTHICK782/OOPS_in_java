package HandlingFilesInJava;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

    void writeFile() throws IOException{
        try{
            FileWriter writer = new FileWriter("contacts.txt");
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print("Hello");
            printWriter.close();
        }
        catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }



}
