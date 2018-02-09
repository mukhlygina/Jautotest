package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import enums.MenuEnum;

public class HeaderMenu<T extends MenuEnum> extends Menu<T> {
    public void mySelect(MenuEnum t) {
        if (t.getLevel() == 2) {
            super.select(MenuEnum.SERVICE.toString());
        }
        super.select(t.toString());
    }
}
