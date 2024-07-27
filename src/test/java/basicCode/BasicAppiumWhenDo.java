package basicCode;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicAppiumWhenDo {
    AndroidDriver driver;
    @BeforeEach
    public void init() throws MalformedURLException {
      //abrir la app
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("appium:deviceName","Diplomado9");
        config.setCapability("appium:platformVersion","9.0");
        config.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        config.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
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
    public void verifyCreateTask() throws InterruptedException {
        // click +
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        // escribir titulo
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("CATO5");
        //  escribir la nota
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("esto es una nota");
        // click en guardar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

        WebDriverWait explicitWait =new WebDriverWait(driver,Duration.ofSeconds(20));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='CATO5']")));

        // Verificar
        String actualResult=driver.findElement(By.xpath("//android.widget.TextView[@text='CATO5']")).getText();
        String expectedResult="CATO5";
        Assertions.assertEquals(expectedResult,actualResult,"La tarea no fue creada!");
    }
}
