package tests;

import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;

public class ErrorNotification_test extends ParentTest
{
    public ErrorNotification_test(String browser)
    {
        super(browser);
    }

    @Test
    public void errorNotificationWhenPurchaseValueIsLessThan8000Test() throws IOException {

        creditPage.openPage();

        creditPage.inputToSummField("100");

        creditPage.pressSubmitButton();

        creditPage.checkErrorNotification();

        //checkAcceptanceCriteria("Error notification is not present", creditPage.checkErrorNotification(),true);
    }
}
