package kata5p2.view;

import java.util.List;
import kata5p2.model.Histogram;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<String> mailList) {
        Histogram<String> histogram = new Histogram<>();
        
        for (String mail : mailList)
               histogram.increment(mail.substring(mail.lastIndexOf("@")+1));
        
        return histogram;
    }
}
