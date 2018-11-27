package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

/**
 * Initialize a driver with test properties
 */
public class Driver extends TestProperties{

    protected static AppiumDriver driver;
    protected DesiredCapabilities capabilities;
    protected static WebDriverWait wait;

    // Properties to be read
    protected static String AUT; // (mobile)app under testing
    protected static String SUT; // site under testing
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String DEVICE_NAME;
    protected static String APP_PACKAGE;
    protected static String APP_ACTIVITY;
    protected static String UDID;

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {

        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = (t_sut == null ? null : "http://" + t_sut);
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("deviceName");
        APP_PACKAGE = getProp("appPackage");
        APP_ACTIVITY = getProp("appActivity");
        UDID = getProp("udid");

        capabilities = new DesiredCapabilities();
        String browserName;

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = "Chrome";
                break;

            case "iOS":
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                browserName = "Safari";
                break;

            default:
                throw new Exception("Unknown mobile platform");
        }

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web (or hybrid)
        if (SUT == null && APP_PACKAGE != null && APP_ACTIVITY != null) {
            // Native
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);

        } else if (SUT != null && APP_PACKAGE == null && APP_ACTIVITY == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);

        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driver for local Appium server with capabilities have been set
        if (driver == null) driver = new AppiumDriver(new URL(DRIVER), capabilities);

        // Set an object to handle timeouts
        if (wait == null) wait = new WebDriverWait(driver(), 10);

    }

    protected AppiumDriver driver() throws Exception {
        if (driver == null) prepareDriver();
        return driver;
    }

    protected WebDriverWait driverWait() throws Exception {
        return wait;
    }
}
