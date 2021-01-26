import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tests extends Configure {


    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date2 = date.minusYears(10);
    Methods methods = new Methods();
    XPath xPath = new XPath();


    @Test
    public void computerAdd() throws InterruptedException {
        methods.openSite(driver, xPath.myUrl);
        driver.findElement(By.id(xPath.addComp)).click();
        methods.waitForElement(driver, xPath.name);
        driver.findElement(By.xpath(xPath.name)).sendKeys(xPath.compName);
        driver.findElement(By.id(xPath.introducedDate)).sendKeys(date2.format(formatter));
        driver.findElement(By.id(xPath.discontinuedDate)).sendKeys(date.format(formatter));
        driver.findElement(By.xpath(xPath.company)).click();
        driver.findElement(By.xpath(xPath.create)).click();
        methods.waitForElement(driver, xPath.successfulMessage);
        if (driver.findElement(By.xpath(xPath.successfulMessage)).isDisplayed()) {
            String textMessage = driver.findElement(By.xpath(xPath.successfulMessage)).getText();
            Assert.assertEquals(textMessage, xPath.rightTextMessage, "The computer was created message is shown");
        } else {
            try {
                throw new NoSuchElementException("The computer was created message isn't shown");
            } catch (NoSuchElementException e) {
                System.out.println("The computer was not created");
                Assert.assertEquals(true, false, "The computer was not created");
            }
        }
        driver.findElement(By.xpath(xPath.foundCompName)).sendKeys(xPath.compName);
        driver.findElement(By.xpath(xPath.filterByName)).click();
        Thread.sleep(5000);
        try {
            String searchResults = driver.findElement(By.xpath(xPath.checkCompName)).getText();
            Assert.assertEquals(searchResults.contains(xPath.compName), true, "The computer is created");
        } catch (NoSuchElementException e) {
            System.out.println("The computer was not created");
            Assert.assertEquals(true, false, "The computer was not created");
        }
    }
}






