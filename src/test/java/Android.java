import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

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
        driver.quit();

    }

    @After
    public void TearDown(){
        System.out.println(testReportURL);

    }
}
