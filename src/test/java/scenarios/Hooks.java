package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;
import setup.PropertyFile;


@Test
public class Hooks extends Driver {

    @BeforeSuite(groups = "native", description = "Prepare driver to run test(s)")
    public void setUpNative() throws Exception {
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = "web", description = "Prepare driver to run test(s)")
    public void setUpWeb() throws Exception {
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @AfterSuite(groups = {"native", "web"}, description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }

}
