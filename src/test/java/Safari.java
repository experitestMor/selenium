
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Safari {
    RemoteWebDriver driver;
    DesiredCapabilities dc;
    String testReportURL;
    @BeforeTest
    public void setup(){
        dc= new DesiredCapabilities();


        dc= DesiredCapabilities.safari();
//        dc.setCapability(CapabilityType.PLATFORM, Platform.WIN10);
//        dc.setCapability(CapabilityType.VERSION, "57.0");
        dc.setCapability("accessKey", "eyJ4cC51IjoxMTIsInhwLnAiOjIsInhwLm0iOiJNVFV5TURnMk16TTJOVGM1TWciLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzg0MDU4NjQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.TXGKg4eRa5CgK-6uzHobOrcuy2zcexm8ZKseLU_5u_E");

        dc.setCapability("generateReport", true);
        dc.setCapability("testName", "Safari Test");
        dc.setCapability("newSessionWaitTimeout", 60);
        dc.setCapability("newCommandTimeout", 60);
        try{
            driver = new RemoteWebDriver(new URL("https://sales.experitest.com/wd/hub/"),dc);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        testReportURL= (String)driver.getCapabilities().getCapability("reportUrl");
    }
    @Test
    public void test(){
        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
        WebElement searchBar = driver.findElement(By.id("lst-ib"));
        searchBar.click();
        searchBar.sendKeys("Experitest");
        searchBar.sendKeys(Keys.ENTER);
    }

    @After
    public void TearDown(){
        driver.quit();
        System.out.println(testReportURL);

    }
}
