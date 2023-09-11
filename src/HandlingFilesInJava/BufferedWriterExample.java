package HandlingFilesInJava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BufferedWriterExample {
    private static final List<Contact> contacts = new ArrayList<>();

    List<String> names = new ArrayList<>(
            Arrays.asList("arun karthick","mak","arunpr","jeeva","sivapradeep","vinnava","sudharshan","jvs","keerthi","vibisan")
    );
    List<String> numbers= new ArrayList<>(
            Arrays.asList("123","234","345","456","567","678","789","890","901","134")
    );
    List<String> tags = new ArrayList<>(
            Arrays.asList("mobile","home","mobile","phone","mobile","work","mobile","home","mobile","home")
    );

    void initializeContacts(){
        for(int i=0;i<10;i++){
            contacts.add(new Contact(names.get(i),tags.get(i),numbers.get(i)));
        }
    }

    void writeFile() throws IOException {
        FileWriter writer = new FileWriter("contacts.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        StringBuffer data = new StringBuffer();
        for(Contact contact : contacts){
            data.append(contact.getName()).append(",");
            for(HashMap<String,String> phoneNumber : contact.getMobileNumberWithTags()){
                for(Map.Entry<String, String> phNo : phoneNumber.entrySet()){
                    data.append(phNo.getKey()).append(",").append(phNo.getValue()).append(",");
                }
                data.append("\n");
            }
        }
        bufferedWriter.write(String.valueOf(data));
        bufferedWriter.close();
    }
}
