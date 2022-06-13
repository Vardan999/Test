import com.company.swaglabs.utils.CustomWebDriver;
import com.company.swaglabs.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = CustomWebDriver.getDriver();
        WaitHelper.waitForJStoLoad();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public WebDriver getDriver() {
        return driver;
    }

//    @AfterSuite
//    public void treeUp() {
//        driver.quit();
//    }
}
