> 1.Add support of appPackage and appActivity parameters for Android devices
    (reading from a .properties file and then setting in the DesiredCapabilities).
      Locally installed Appium DT has no need in these parameters, but for Appium server of Minsk Mobile Farm it’s mandatory.

In Driver class:
```sh
    protected static String APP_PACKAGE;
    protected static String APP_ACTIVITY;
```
In prepareDriver() method:
```sh
    APP_PACKAGE = getProp("appPackage");
    APP_ACTIVITY = getProp("appActivity");
    
    if (SUT == null && APP_PACKAGE != null && APP_ACTIVITY != null) {
         // Native
         capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
         capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
    }
```
In properties file:
```sh
     appPackage=com.example.android.contactmanager
     appActivity=.ContactManager
```               


> 2.Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. Did test pass?

In Driver class:
```sh
    protected static String UDID;
```
In prepareDriver() method:
```sh
   UDID = getProp("udid");
   
   case "iOS":
                   capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                   browserName = "Safari";
                   break;
```
In properties file:
```sh
     platform=iOS
     udid=4dc76c4ed56e4db389bee0c6dcb97e13973b5821
```     
>3.Change settings to run native test on a certain/random Android device on Mobile Test Farm. Run test with your changes. Did test pass?

In Driver class:
```sh
    protected static String DEVICE_NAME;
```
In prepareDriver() method:
```sh
   DEVICE_NAME = getProp("deviceName");
   
   case "Android":
                  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                  browserName = "Chrome";
                  break;
```
In properties file:
```sh
     platform=Android
     deviceName=LGE Nexus 5
```    

>4.What’s wrong with our code? How to fix/improve it? Implement your suggestions.

There are too many hardcoded places, which could cause an error. 
And we can use @AndroidFindBy and @iOSFindBy annotations instead of just @FindBy.