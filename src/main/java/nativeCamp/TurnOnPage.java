package nativeCamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TurnOnPage {

    //https://www.guru99.com/first-webdriver-script.html

    private static final String nativeCampUrl = "https://nativecamp.net/zh-tw/waiting/detail/6599";
    private static WebDriver driver;
    static {
        try {
            System.setProperty("webdriver.gecko.driver","C:\\crawler\\geckodriver.exe");
            driver = new FirefoxDriver();
        } catch (IllegalStateException e) {
            System.out.println("Error when set property: webdriver.gecko.driver");
            driver = null;
        }
    }

    private static void turnOnPage() throws Exception {

        driver.get(nativeCampUrl);
//        driver.getPageSource();

    }

    public static void main(String[] args) throws Exception {
       turnOnPage();


    }

}
