package site;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.User;
import org.openqa.selenium.support.FindBy;
import site.pages.IndexPage;
import site.pages.MetalsColorsPage;
import site.sections.HeaderMenu;
import site.sections.LoginForm;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
    public static LoginForm loginForm;

    @JPage(url = "index.html")
    public static IndexPage indexPage;

    @JPage(url = "page2.htm")
    public static MetalsColorsPage metalsColorsPage;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @FindBy(css = "ul.m-l8 li")
    public static HeaderMenu headerMenu;

    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }
}
