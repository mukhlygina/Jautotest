package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsAndColors;
import org.openqa.selenium.support.FindBy;

public class ElementsForm extends Form<MetalsAndColors> {
    @FindBy(css = "#elements-checklist label")
    public CheckList element;

    @FindBy(css = "#even-selector p")
    public RadioButtons even;

    @FindBy(css = "#odds-selector p")
    public RadioButtons odd;

    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li")
    )
    public Dropdown color;

    @JDropdown(
            root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li")
    )
    public Dropdown metal;

    @FindBy(css = ".salad .caret")
    public Button expandSaladList;

    @FindBy(css = ".salad ul li")
    public CheckList salad;

    @FindBy(css = "#submit-button")
    public Button submit;

    public void fillForm(MetalsAndColors metalsAndColors) {
        element.check(metalsAndColors.elements);
        odd.select(metalsAndColors.summary[0].toString());
        even.select(metalsAndColors.summary[1].toString());
        color.select(metalsAndColors.color);
        metal.select(metalsAndColors.metals);
        expandSaladList.click();
        salad.check("Salad");
        salad.check(metalsAndColors.vegetables);
        submit.click();
    }

}
