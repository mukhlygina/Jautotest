package site;

import com.epam.jdi.uitests.core.interfaces.base.ISetup;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

public class DropdownList extends DropList implements ISetup {
    @Override
    public void setup(Field field) {
        super.setUp(this, field);
    }

    @Override
    public void clear() {
        if (button() != null)
            expandAction(1);

        List<WebElement> elements = getElements();
        elements.stream().filter(el -> el.findElement(By.cssSelector("input")).isSelected()).forEach(el -> {
            el.click();
        });
    }
}
