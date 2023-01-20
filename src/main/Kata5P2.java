package main;
import java.util.ArrayList;
import java.util.List;
import model.*;
import view.*;
import view.MailListReaderBD;

public class Kata5P2 {
    private static String fileName = "email.txt";
    private static List<Mail> mailList = new ArrayList<Mail>();
    private static Histogram<String> histogram;
    
    public static void main(String[] args) {
        execute();
    }
    
    private static void execute(){
        input();
        process();
        output();
    }
    
    private static void input(){
        mailList = MailListReaderBD.read(fileName);   
    }    

    private static void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private static void output() {
        new HistogramDisplay(histogram, "Histograma Dominios emails").execute();
    }
   
}