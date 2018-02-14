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
        String[] elements = {"Water", "Fire"};
        String[] salads = {"Cucumber", "Tomato"};
        Integer[] sum = {3, 8};
        MetalsAndColors data = new MetalsAndColors(sum, elements, "Red", "Selen", salads);
        headerMenu.selectMenu(MenuEnum.DATES);
        headerMenu.selectMenu(MenuEnum.METALS_COLORS);
        metalsColorsPage.elementsForm.fillAndSubmitForm(data);
        metalsColorsPage.resultsSection.checkResults(data);
    }
}
