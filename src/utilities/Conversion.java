package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {
    public static String convertCountry(String shortCountry)
    {
        String convertedCountry = "";

        switch (shortCountry)
        {
            case  "IN" : convertedCountry ="India";break;
            case  "AF" : convertedCountry ="Afghanistan";break;
            case  "AO" : convertedCountry ="Angola";break;
            case  "BE" : convertedCountry ="Belgium";break;
        }

        return convertedCountry;
    }

    public static String genderFull(String genderID)
    {
        String fullGender = "";

        switch (genderID)
        {
            case "0" : fullGender ="Male";break;
            case "1" : fullGender ="Female";break;
            case "2" : fullGender ="Other";break;
        }

        return  fullGender;
    }


    public static  String convertDate(String dbDate) throws ParseException // yyyy-MM-dd
    {
       Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);
       // date to string --> MM/dd/yyyy
       return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }



    }
