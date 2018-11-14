> 1.Setup project that has been discussed in the class.
> Make sure you can run both tests (native and web) successfully.

Both tests that has been discussed in class run successfully and located in "src/test/java/scenarios" directory.

> 2.For existing native mobile autotest try to use another locator (xpath, classname, ?). 
> Define these locators using Appium Inspector. Are there any difference with id version?

In my autotest I have tried to use different locators:

        // Locator by id
        // By add_btn = By.id("com.example.android.contactmanager:id/addContactButton");

        // Locator by xpath
        // By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");

        // Locator by className
        // By add_btn = By.className("android.widget.Button");
        
The difference in usage was that with id version application was falling with InvalidSelectorException,
but with xpath and className worked successfully.

> 3.Modify existing tests to run on a real device. What should be changed? 

        Firstly, we have to turn on Developer options on the device. 
        Then, with help of ADB we have to get access to our device via USB or WiFi(TCP/IP).
        Then, with help of "adb devices" command, we are looking for "deviceName" 
        Finally, we need to change this "deviceName" capability to ours. 

> 4.Connect a real device to Appium (describe required actions) and run tests. 
> Are there any difference with run on emulator?

I do not have real device but if I could try to do this there should not be any differences with run on emulator.

> 5.What should be improved/changed in existing test code? Why, for what?

        5.1. We should remove all hardcoded parts of our code, because it is easy to make a mistake while changing it.
        5.2. We have to change the way we are running native and web tests. It is not right to run one by comment out another.
        5.3. We should not use Thread.sleep()  
        5.4. We should use logging instead of using System.out.println()  


