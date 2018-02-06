package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import site.sections.ElementsForm;

@JPage(url = "page2.htm")
public class MetalsColorsPage extends WebPage {
    public ElementsForm elementsForm;
}
