package bi3.framework.config;

import java.io.FileInputStream;
import java.util.Properties;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
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
  
  public static void setProperties() {
    Properties properties = new Properties();
    try {
      FileInputStream _fileInputStream = new FileInputStream(".\\src\\main\\resources\\config\\config.properties");
      properties.load(_fileInputStream);
      ConfigKeys.BROWSER_TYPE = properties.getProperty("BROWSER_TYPE");
      ConfigKeys.BASE_URL = properties.getProperty("BASE_URL");
      ConfigKeys.CHROME_DRIVER_PATH = properties.getProperty("CHROME_DRIVER_PATH");
      ConfigKeys.SCREENSHOT_PATH = properties.getProperty("SCREENSHOT_PATH");
      ConfigKeys.DATA_HELPER_PATH = properties.getProperty("DATA_HELPER_PATH");
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        System.exit(0);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
