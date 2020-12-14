package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ATMsPage;
import pages.CreditPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
public class ParentTest
{
    WebDriver driver;
    Logger log;

    public CreditPage creditPage;
    public ATMsPage atmPage;

    @Before
    public void setUp() throws Exception {

        webDriver = driverInit();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        creditPage = new CreditPage(driver);
        atmPage = new ATMsPage(driver);

    }

    private WebDriver driverInit()  {

        WebDriverManager.chromedriver().setup();
        log.info("Chrome Driver is setup");
        return new ChromeDriver();

    }

}

    @After
    public void tearDown() {
        driver.quit();
    }

    protected void checkAcceptanceCriteria(String message, boolean actual, boolean expected){
        Assert.assertThat(message, actual, is (expected));
        isTestPass = true;
    }

    protected void checkAcceptanceCriteria(String message, String actual, String expected){
        Assert.assertThat(message, actual, is (expected));
        isTestPass = true;
    }

}
