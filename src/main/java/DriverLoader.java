import java.util.Properties;

public class DriverLoader {
    public void DriverLoader() {
        Properties property = new Properties();

        try {
            property.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            System.out.println("Fail " + e);
        }

        System.setProperty("webdriver.chrome.driver", property.getProperty("chrome_executable_path"));
//        System.setProperty("webdriver.gecko.driver", config.getProperty("firefox_executable_path"));

    }
}
