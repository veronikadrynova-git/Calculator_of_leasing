package libs;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIActions
{
    Logger log;
    WebDriver driver;
    JavascriptExecutor executor;
    WebDriverWait webDriverWait;

    public UIActions(WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        webDriverWait = new WebDriverWait (driver, 20);
    }
    /** Method click to element
     * @param element
     */
    public void clickToElement(WebElement element)
    {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            log.info("Element was clicked");
        }
        catch(Exception ex)
        {
            log.error("Can't click to the element"+ex);
        }
    }

    /** Input value to web element
     * @param element
     * @param value
     */
    public void inputToTextField(WebElement element, String value)
    {
        try {
            element.clear();
            element.sendKeys(value);
            log.info("The value is input");
        }
        catch (Exception ex)
        {
            log.error("Can't input value to the element"+ex);
        }
    }

    /** Click to the checkbox
     * @param element
     * @param IsFinalResult
     */
    public  void clickToCheckbox (WebElement element, boolean IsFinalResult)
    {
        try
        {
            if ((element.isSelected()&&!(IsFinalResult))
                    ||!(element.isSelected()&&IsFinalResult))
            {
                element.click();
                log.info("Element is clicked");
            }
        }
        catch (Exception ex)
        {
            log.error("Can't click element");
        }
    }

    /** Choose row from dropdown list
     * @param element
     * @param row
     */
    public void chooseElementFromDropdown(WebElement element,String row)
    {
        try {
            /**element.click();
             //row.click();
             **/Select optionsFromDD = new Select(element);
            optionsFromDD.selectByVisibleText(row);
            log.info("Element is chosen");
        }
        catch (Exception ex)
        {
            log.error("Can't choose the element");
        }
    }

    /** Try if the element is displayed and if it is enabled
     * @param element
     * @return
     */
    public boolean isElementVisible(WebElement element)
    {
        try {
            log.info("Element is enabled");
            return element.isDisplayed()&&element.isEnabled();
        }
        catch (Exception ex)
        {
            log.error("Can't find the element");
        }
        return false;
    }

    /** Try if the element is displayed
     * @param element
     * @return
     */
    public boolean isElementDisplayed(WebElement element)
    {
        try {
            log.info("Element is displayed");
            return element.isDisplayed();
        }
        catch (Exception ex)
        {
            log.error("Can't find the element");
        }
        return false;
    }
}
