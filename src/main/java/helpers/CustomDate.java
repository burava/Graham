package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDate {
    public static String getDateNow(String format){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
}
