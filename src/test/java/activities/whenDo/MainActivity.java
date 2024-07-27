package activities.whenDo;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class MainActivity {

    public Button addButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public boolean isTaskDisplayedInList(String nameTask){
        Label taskLabel = new Label(By.xpath("//android.widget.TextView[@text='"+nameTask+"']"));
        return taskLabel.isControlDisplayed();
    }
}

