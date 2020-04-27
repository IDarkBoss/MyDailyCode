package app;

import java.util.Date;
import org.joda.time.DateTime;

public class getTime {
    public static void main(String[] args) throws Exception {
        Date valueDate = new DateTime(new Date()).withTime(0, 0, 0, 0).toDate();
        System.out.println(valueDate);
    }
}


