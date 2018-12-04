package appAutomate;

import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstAppAutomate {




    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
        String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
        String app = System.getenv("BROWSERSTACK_APP_ID");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Samsung Galaxy S8");
        capabilities.setCapability("app", app);
        capabilities.setCapability("browserstack.local", browserstackLocal);
        capabilities.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);

        //driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);

        //IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://"+userName+":"+accessKey+"@hub.browserstack.com/wd/hub"), capabilities);

       /*WebDriver augmentedDriver = new Augmenter().augment(driver);
    	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);*/
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.getOrientation();
        ((RemoteWebDriver) driver).getSessionId();


        Thread.sleep(5000);

        String time = driver.getDeviceTime();
        System.out.println(time);
        //  List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        /*assert(allProductsName.size() > 0);
        ((RemoteWebDriver) driver).getSessionId();
*/
        driver.quit();
    }

}

