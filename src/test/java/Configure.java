import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Configure {
    ChromeDriver driver;

    @BeforeTest
    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterTest
    public void afterTest() {
       driver.quit();
    }

}
