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

public class ChromeTestV64 {
    RemoteWebDriver driver;
    DesiredCapabilities dc;
    @BeforeTest
    public void setup(){
        dc= new DesiredCapabilities();
        dc.setCapability(CapabilityType.PLATFORM, Platform.WIN10);
        dc.setCapability("username", "<cloudUsername>");
        dc.setCapability("password", "<cloudPassword>");
        dc.setCapability("projectName", "<cloudProject>"); //only required if your user has several projects assigned to it. Otherwise, exclude this capability.
        dc.setCapability("generateReport", true);
        dc.setCapability("testName", "<testName>");
        dc.setCapability("newSessionWaitTimeout", 90);
        dc.setCapability(CapabilityType.VERSION, "52.0.2");
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        dc.setCapability("newCommandTimeout", 120);
        try{

        driver = new RemoteWebDriver(new URL("https://localhost:9192/wd/hub/"),dc);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        String testReportUrl = (String)driver.getCapabilities().getCapability("reportUrl");
    }
    @Test
    public void test(){

    }

    @After
    public void TearDown(){

    }
}
