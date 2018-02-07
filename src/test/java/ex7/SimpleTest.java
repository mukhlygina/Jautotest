package ex7;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import entities.MetalsAndColors;
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

        // TODO Common Wrapper error, you can find it out in Skype
        login();

        // TODO that's wont work in case if you try to open sub-menu (Dates, for example)
        headerMenu.clickOn(MenuEnum.METALS_COLORS.title);


        metalsColorsPage.elementsForm.submit(new MetalsAndColors());
        metalsColorsPage.resultsForm.checkForm(new MetalsAndColors());
    }
}
