package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

public class Control {
    protected By locator;
    protected WebElement control;

    public Control(By locator){
        this.locator = locator;
    }

    public void findControl(){
        this.control = Session.getSession().getDevice().findElement(locator);
    }

    public void click(){
        this.findControl();
        this.control.click();
    }

    public String getText(){
        this.findControl();
        return this.control.getText();
    }

    public boolean isControlDisplayed(){
        try {
            this.findControl();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
