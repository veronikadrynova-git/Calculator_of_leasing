package pages;
import libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
public class CreditPage extends ParentPage
{
    @FindBy(name = "summa")
    WebElement InputTotalSummXpath;

/*    @FindBy(xpath = ".//*input[@name='summa' and @type='text']")
    WebElement InputTotalSummXpath;*/

    @FindBy(xpath = ".//*[@id=\"f-summa-error\"]")
    WebElement SummErrorXpath;

    @FindBy(xpath = ".//button[@type='submit']")
    WebElement SubmitButtonXpath;

    @FindBy(xpath = "/a[@href=\"/eng/private/atms-and-branches\"]")
    WebElement ATMsLinkXpath;

    @FindBy(xpath = "/span[@class=\"calc-result\"]/text()")
    WebElement FirstInstallmentXpath;

    public CreditPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() throws IOException
    {
        try
        {
            driver.get(ConfigData.getCfgValue("base_url")+"/private/calculator-leasing");
            log.info("'Calculator of leasing' page was opened");
        }
        catch (Exception ex)
        {
            log.error("Cannot find 'Calculator of leasing' page's url");
        }
    }

    public void inputToSummField(String value)
    {
        uiactions.inputToTextField(InputTotalSummXpath, value);
    }


    public void pressSubmitButton()
    {
        uiactions.clickToElement(SubmitButtonXpath);
    }


    public void pressLinkATMs()
    {
        uiactions.clickToElement(ATMsLinkXpath);
    }


    public void checkErrorNotification() { uiactions.isElementVisible(SummErrorXpath); }


    public void isFirstInstallmentCorrect()
    {
        uiactions.isElementDisplayed(FirstInstallmentXpath);
    }

}
