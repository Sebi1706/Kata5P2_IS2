package view;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.*;

public class MailListReader{

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
