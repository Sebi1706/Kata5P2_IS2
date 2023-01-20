package view;
import java.util.*;
import model.*;


public class MailHistogramBuilder{

    public static Histogram<String> build(List<Mail> lista) {
        Histogram<String> histogram = new Histogram<String>();
        for (Mail mail : lista) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
}
