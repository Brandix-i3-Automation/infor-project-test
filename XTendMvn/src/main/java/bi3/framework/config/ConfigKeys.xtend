package bi3.framework.config

import java.util.Properties
import java.io.FileInputStream

public class ConfigKeys {

    public static String BROWSER_TYPE;
    public static String BIT_VERSION;
    public static int TIME_OUT;
    public static int DEFAULT_TIMEOUT;

    public static String BASE_URL;
    public static String CHROME_DRIVER_PATH;
    public static String IE_64_DRIVER_PATH;
    public static String IE_32_DRIVER_PATH;
    public static String SCREENSHOT_PATH;
    public static String FAIL_RETRY_COUNT;
    
    public static String DATA_HELPER_PATH;

    def static void setProperties(){

        var Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(".\\src\\main\\resources\\config\\config.properties"));
            BROWSER_TYPE = properties.getProperty("BROWSER_TYPE");
            //TIME_OUT = Integer.parseInt(properties.getProperty("TIME_OUT"));
            //DEFAULT_TIMEOUT = Integer.parseInt(properties.getProperty("DEFAULT_TIMEOUT"));

            BASE_URL = properties.getProperty("BASE_URL");
            CHROME_DRIVER_PATH = properties.getProperty("CHROME_DRIVER_PATH");
            //IE_64_DRIVER_PATH = properties.getProperty("IE_64_DRIVER_PATH");
            //IE_32_DRIVER_PATH  = properties.getProperty("IE_32_DRIVER_PATH");

            SCREENSHOT_PATH = properties.getProperty("SCREENSHOT_PATH");
            
            DATA_HELPER_PATH = properties.getProperty("DATA_HELPER_PATH");

        } catch (Exception ex) {
            System.exit(0);
        }
    }
}