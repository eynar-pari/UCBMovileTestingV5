package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android implements IDevices{
    @Override
    public AndroidDriver create() {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("appium:deviceName","Diplomado9");
        config.setCapability("appium:platformVersion","9.0");
        config.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        config.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        config.setCapability("platformName","Android");
        config.setCapability("appium:automationName","uiautomator2");
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),config);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }
}
