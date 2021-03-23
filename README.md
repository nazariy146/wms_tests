# WMS_tests

## Mobile automation 

### How to run the example

* Run the emulator:
  > open Android Studio -> "Android Virtual Device Manager" -> Run Pixel_4_XL_API_29

* Run appium server:
   > appium
   
* Check your device name via command line
   > adb devices

* Set you device name into src/test/java/tests/BaseMobileClass.java 
   > setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
   
* Open src/test/java/tests/scenarios/WorkWithDailyTasksTest.java -> right mouse click -> Run
