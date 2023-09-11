package HandlingFilesInJava;


public class Main {
    public static void main(String[] args) {
        BufferedWriterExample bufferedWriterExample = new BufferedWriterExample();
        bufferedWriterExample.initializeContacts();
        try{
            bufferedWriterExample.writeFile();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
