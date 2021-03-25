package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        // 1. read the file
        FileInputStream fis = new FileInputStream("Config\\config.properties");

        // 2. create an object of properties class
        Properties prop = new Properties();

       // 3. load this properties object with the file object
       prop.load(fis);

       // 4. Read the value of a key
        String myUrl = prop.getProperty("url");
        System.out.println("url="+myUrl);


    }
}
