package kata4.main;

import kata4.view.MailHistogramReader;
import kata4.view.MailHistogramBuilder;
import kata4.model.Mail;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.HistogramDisplay;

public class Kata4 {
    
     private static String fileName;
     private static List<Mail> mailList; 
     private static Histogram<String> histogram;

    public static void main(String[] args) {
        
        fileName = "email.txt";
        execute();
        
    }
    
    private static void execute(){
        
        input();
        process();
        output();
    }
    
    private static void input(){
        
        mailList = MailHistogramReader.read(fileName);
        
    }
    
    private static void process(){
        
        histogram = MailHistogramBuilder.built(mailList);
        
    }
    
    private static void output(){
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("Histograma", histogram);
        histogramDisplay.execute();
        
    }
    
}
