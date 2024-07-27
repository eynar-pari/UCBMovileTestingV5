package basicCode;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicAppium {
    AndroidDriver driver;
    @BeforeEach
    public void init() throws MalformedURLException {
      //abrir la app
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("appium:deviceName","Diplomado9");
        config.setCapability("appium:platformVersion","9.0");
        config.setCapability("appium:appPackage","com.android.calculator2");
        config.setCapability("appium:appActivity","com.android.calculator2.Calculator");
        config.setCapability("platformName","Android");
        config.setCapability("appium:automationName","uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),config);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @AfterEach
    public void clean(){
      // cerrar app
        driver.quit();
    }

    @Test
    public void verifyAddCalculator() throws InterruptedException {
        // steps
        // click 8
        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        //click +
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        //click 4
        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
        // click =
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        Thread.sleep(5000);
        //verificacion
        // verificar que el resultado sea 12
        String expectedResult="12";
        String actualResult=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        Assertions.assertEquals(expectedResult,actualResult,
                "La suma es incorrecta");

    }
}
