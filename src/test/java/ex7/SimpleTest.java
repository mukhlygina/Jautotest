package ex7;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import entities.MetalsAndColors;
import entities.User;
import enums.MenuEnum;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import site.JDISite;

import static site.JDISite.*;

public class SimpleTest extends TestNGBase {

    @BeforeSuite
    public void setUp() {
        WebSite.init(JDISite.class);
    }

    @Test
    public void loginTest() {
        indexPage.open();
        login(new User());
        // TODO data should be encapsulated in MetalsAndColors class
        String[] elements = {"Water", "Fire"};
        String[] salads = {"Cucumber", "Tomato"};
        MetalsAndColors data = new MetalsAndColors(elements, 3, 8, "Selen", "Red", salads);
        // TODO this will not work in case if you try to open sub-menu (Dates, for example)
        headerMenu.clickOn(MenuEnum.METALS_COLORS);
        metalsColorsPage.elementsForm.fillForm(data);
        metalsColorsPage.resultsSection.checkResults(data);
    }
}
