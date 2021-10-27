package tests.utils;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Actions {

    public static void refreshPage(SelenideElement element) {
        AndroidDriver driver = (AndroidDriver) element.getWrappedDriver();

        TouchAction touchAction= new TouchAction(driver);

        touchAction.press(point(100, 400))
                .waitAction(WaitOptions.waitOptions(ofMillis(300)))
                .moveTo(point(100, 900))
                .release().perform();
    }

    public static void scrollElement(SelenideElement element) {
        AndroidDriver driver = (AndroidDriver) element.getWrappedDriver();

        TouchAction touchAction= new TouchAction(driver);

        touchAction.press(point(element.getLocation().x, element.getLocation().y))
                .waitAction(WaitOptions.waitOptions(ofMillis(300)))
                .moveTo(point(element.getLocation().x, element.getLocation().y-846))
                .release().perform();
    }

    public static void hideKeyboard() {
        AppiumDriver driver = (AppiumDriver) $(By.id("com.abmcloud:id/action_more_menu")).getWrappedDriver();
        driver.hideKeyboard();
    }

    public static void backPage (SelenideElement element){
        AndroidDriver driver = (AndroidDriver) element.getWrappedDriver();
        TouchAction touchAction= new TouchAction(driver);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void fieldEnter (SelenideElement element){
        AndroidDriver driver = (AndroidDriver) element.getWrappedDriver();
        TouchAction touchAction= new TouchAction(driver);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
