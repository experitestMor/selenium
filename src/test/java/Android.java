import com.experitest.client.InternalException;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class Android {
    RemoteWebDriver driver;
    DesiredCapabilities dc;
    String testReportURL;
    @BeforeTest
    public void setup(){
        dc= new DesiredCapabilities();


        dc= DesiredCapabilities.android();
//        dc.setCapability(CapabilityType.PLATFORM, Platform.WIN10);
//        dc.setCapability(CapabilityType.VERSION, "57.0");
        dc.setCapability("username", "mor.hazan");
        dc.setCapability("password", "nopsw2Hj");
        dc.setCapability("projectName", "Default"); //only required if your user has several projects assigned to it. Otherwise, exclude this capability.
        dc.setCapability("generateReport", true);
        dc.setCapability("testName", "Android Chrome Test");
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
        driver.get("https://www.premierleague.com/tables");
        WebElement element = driver.findElementByXPath("//*[@id=\"mainContent\"]/div[2]/div[1]/div[3]/div/div/div/table/tbody/tr[1]/td[3]/a/span[2]");
        element.click();
        element = driver.findElementByXPath("//*[@id=\"mainContent\"]/nav/ul/li[2]/a");
        element.click();
        try{
            sleep(10000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();

    }

    @After
    public void TearDown(){
        System.out.println(testReportURL);

    }
}
