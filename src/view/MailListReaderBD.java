package view;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReaderBD {
    private final List<String> domainsList = new ArrayList();

    public List<String> addDomains(List<Mail> items){
        for (Mail line : items) {
            domainsList.add(line.getDomain());
        }
        return domainsList;
    }

    public static List<Mail> read(String fileName) {
        BufferedReader br = null;
        List<Mail> mails = new ArrayList<Mail>();
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String linea;
            while ((linea = br.readLine()) != null) {
            if (linea.contains("@")){
                mails.add(new Mail(linea));
            }
            else{
                continue;
            }
            
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return mails;
    }
}