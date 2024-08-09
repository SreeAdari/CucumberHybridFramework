package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME_OUT = 15;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30;

    public String getEmailWithTimeStamp() {
        // Create a Date object
        Date date = new Date();
        
        // Define the date format for the timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        
        // Format the current date as a string
        String timestamp = sdf.format(date);
        
        // Return the email with the timestamp
        return "srinu_" + timestamp + "@gmail.com";
    }
}
