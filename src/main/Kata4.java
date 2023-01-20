package main;
import java.util.ArrayList;
import java.util.List;
import model.*;
import view.*;

public class Kata4 {
    private static String fileName = "email.txt";
    private static List<Mail> mailList = new ArrayList<Mail>();
    private static Histogram<String> histogram = new Histogram<String>();
    private static HistogramDisplay histogramDisplay;
    
    public static void main(String[] args) {
        
        execute();
    }
    
    private static void execute(){
        input();
        process();
        output();
    }
    
    private static void input(){
        mailList = MailListReader.read(fileName);   
    }    

    private static void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private static void output() {
        new HistogramDisplay(histogram, "Histograma Dominios emails").execute();
    }
   
}