package scenarios.webTests;

import org.testng.annotations.Test;
import setup.Driver;

import static org.testng.Assert.assertEquals;


@Test(groups = "web")
public class SimpleWebTest extends Driver {

    String pageTitle = "Internet Assigned Numbers Authority";

    @Test(description = "Open website")
    public void webTest() throws Exception {

        driver.get(SUT);

        //=================== My Checks ========================================================

        assertEquals(driver().getCurrentUrl(), SUT + "/");
        assertEquals(driver().getTitle(), pageTitle);

        System.out.println("Site opening done");
    }


}
