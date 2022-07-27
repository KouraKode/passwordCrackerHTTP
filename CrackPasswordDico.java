import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class CrackPasswordDico extends CrackPassword{


    protected void search(User user) throws IOException {
        InputStream file = new FileInputStream("dico.txt");
        boolean found = false;
        long start = 0;
        try (Scanner obj = new Scanner(file)) {
            System.out.println("Waiting for...............");
            start = System.currentTimeMillis();
            String line = "";
            while(obj.hasNextLine()){
                line = obj.nextLine();
                // System.out.println(line);
                if(user.authentificate(line)){
                    found = true;
                    break;
                }
            }
            super.printResult((found) ? line : "", found, System.currentTimeMillis()-start);
        }
    }
    
}
