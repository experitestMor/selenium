import org.junit.After;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTestV63 {
    RemoteWebDriver driver;
    DesiredCapabilities dc;
    @BeforeTest
    public void setup(){
        dc= new DesiredCapabilities();
        dc.setCapability(CapabilityType.PLATFORM, Platform.WIN10);
        dc.setCapability("username", "mor.hazan");
        dc.setCapability("password", "nopsw2Hj");
        dc.setCapability("projectName", "Default"); //only required if your user has several projects assigned to it. Otherwise, exclude this capability.
        dc.setCapability("generateReport", true);
        dc.setCapability("testName", "Chrome v63");
        dc.setCapability("newSessionWaitTimeout", 60);
        dc.setCapability("newCommandTimeout", 60);
        dc.setCapability(CapabilityType.VERSION, "63.0.0");
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

        try{

        driver = new RemoteWebDriver(new URL("https://sales.experitest.com/wd/hub/"),dc);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        String testReportUrl = (String)driver.getCapabilities().getCapability("reportUrl");
    }
    @Test
    public void test(){
        driver.get("https://www.premierleague.com/tables");

    }

    @After
    public void TearDown(){

    }
}
