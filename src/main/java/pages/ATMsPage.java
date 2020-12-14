package pages;

import libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class ATMsPage extends ParentPage
{
@FindBy(xpath = "/a[@href=\"/eng/private/atms-and-branches\"]")
    WebElement ATMsPageXpath;



public ATMsPage(WebDriver driver) {
        super(driver);
        }

public void openATMsPage() throws IOException
        {
        try
        {
        driver.get(ConfigData.getCfgValue("base_url")+"/atms-and-branches-0");
        log.info("ATM's Page was opened");
        }
        catch (Exception ex)
        {
        log.error("Cannot find ATM's Page's url");
        }
        }
}
