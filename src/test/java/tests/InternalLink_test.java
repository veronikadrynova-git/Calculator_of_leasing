package tests;

import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;

public class InternalLink_test extends ParentTest
{
    public InternalLink_test(String browser)
    {
        super(browser);
    }

    @Test
    public void internalLinkOpensATMsPageCorrectlyTest() throws IOException {

        creditPage.openPage();

        creditPage.pressLinkATMs();

        atmPage.openATMsPage();

        //checkAcceptanceCriteria("ATMs Page is not opened", atmPage.openATMsPage(),true);

    }
}
