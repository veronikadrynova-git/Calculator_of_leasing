package tests;

import org.junit.Test;
import parentTest.ParentTest;
import java.io.IOException;

public class Valid_test extends ParentTest
{
    public Valid_test(String browser)
    {
        super(browser);
    }

    @Test
    public void validFirstInstallmentTest() throws IOException {

        creditPage.openPage();

        creditPage.inputToSummField("20000");

        creditPage.pressSubmitButton();

        checkAcceptanceCriteria("First installment has not correct value", creditPage.isFirstInstallmentCorrect('2 000.00'),true);

    }
}
