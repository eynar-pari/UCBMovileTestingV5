package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class WhenDoTest extends TestBase{

    @Test
    public void verifyCreateTask(){
        String nameTask = "cato"+new Date().getTime();
        mainActivity.addButton.click();
        taskFormActivity.titleTextBox.setText(nameTask);
        taskFormActivity.noteTextBox.setText("esto es una nota creada");
        taskFormActivity.saveButton.click();
        Assertions.assertTrue(mainActivity.isTaskDisplayedInList(nameTask));
    }
}
