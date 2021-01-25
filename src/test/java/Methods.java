import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Optional;

public class Methods {

    private final int INTERVAL = Integer.parseInt(Optional.ofNullable(System.getenv("INTERVAL")).orElse("20"));

    public void waitForElement(ChromeDriver chromeDriver, String xPath) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(chromeDriver, INTERVAL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        Thread.sleep(1000);
    }
    public void openSite(ChromeDriver chromeDriver, String urlAddress) {
        chromeDriver.get(urlAddress);
//        chromeDriver.manage().window().maximize();
    }
}
