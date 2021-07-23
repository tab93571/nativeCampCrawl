package nativeCamp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Crawler {

    //https://www.guru99.com/first-webdriver-script.html

    private static final String HKSIX_URL = "https://bet.hkjc.com/marksix/Fixtures.aspx?lang=ch";
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

    private static String crawlHksix() throws Exception {
        String htmlSource;
        int retry, maxRetry = 120;
        driver.get(HKSIX_URL);
        htmlSource = driver.getPageSource();
        retry = 0;
        while (htmlSource == null || htmlSource.isEmpty() || !htmlSource.contains("mscalTD mscalDrawDay")) {
            htmlSource = driver.getPageSource();
            Thread.sleep(1000);
            retry++;
            if (retry == maxRetry)
                throw new Exception("Can't load hksix website in 120 retry times");
        }
        driver.close();
        return htmlSource;
    }

    public static void main(String[] args) throws Exception {
        String result = crawlHksix();
        Document document = Jsoup.parse(result);

        Elements dateList = document.getElementsByAttributeValue("id", "trayPullDown").get(0).children();
        dateList.forEach(date -> {
            if (date.hasAttr("selected"))
                System.out.println(date.text());
        });

        Elements openLotteryDays;
        openLotteryDays = document.getElementsByClass("mscalTD mscalDrawDay");
        openLotteryDays.forEach(element -> System.out.println(element.text()));
    }

}
