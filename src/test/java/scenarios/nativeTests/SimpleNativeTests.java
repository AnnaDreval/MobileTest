package scenarios.nativeTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.Driver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Test(groups = "native")
public class SimpleNativeTests extends Driver {

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() throws Exception{

        String app_package_name = "com.example.android.contactmanager:id/";

        //=================== Click "Add Contact" button ================================================
        By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");
        driver.findElement(add_btn).click();

        //=================== Check Targer Account ======================================================
        By targetTitle_btn = By.xpath("//android.widget.TextView[@content-desc='Target Account']");
        assertEquals(driver().findElement(targetTitle_btn).getText(), "Target Account");

        By targetText_btn = By.id(app_package_name + "accountSpinner");
        assertTrue(driver().findElement(targetText_btn).isDisplayed());

        //=================== Check Contact Name ========================================================
        By contactName_btn = By.xpath("//android.widget.TextView[@content-desc='Contact Name']");
        assertEquals(driver().findElement(contactName_btn).getText(), "Contact Name");

        By contactNameTxt_btn = By.id(app_package_name + "contactNameEditText");
        assertTrue(driver().findElement(contactNameTxt_btn).isDisplayed());

        //=================== Check Contact Phone =======================================================
        By contactPhone_btn = By.xpath("//android.widget.TextView[@content-desc='Contact Phone']");
        assertEquals(driver().findElement(contactPhone_btn).getText(), "Contact Phone");

        By contactPhoneTxt_btn = By.id(app_package_name + "contactPhoneEditText");
        assertTrue(driver().findElement(contactPhoneTxt_btn).isDisplayed());

        System.out.println("Simple Appium test done");
    }

}
