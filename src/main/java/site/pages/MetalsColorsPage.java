package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import site.sections.ElementsForm;
import site.sections.ResultsForm;

@JPage(url = "page2.htm")
public class MetalsColorsPage extends WebPage {
    public ElementsForm elementsForm;

    // TODO thi is NOT a form, i guess
    public ResultsForm resultsForm;
}
