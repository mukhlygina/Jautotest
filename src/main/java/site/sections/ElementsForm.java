package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsAndColors;
import org.openqa.selenium.support.FindBy;
import site.DropdownList;

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

    @JDropList(
            root = @FindBy(css = ".salad"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li")
    )
    public DropdownList salad;

    @FindBy(css = "#submit-button")
    public Button submit;

    public void fillAndSubmitForm(MetalsAndColors metalsAndColors) {
        element.clear();
        if(metalsAndColors.elements.length != 0) {
            element.check(metalsAndColors.elements);
        }

        if(metalsAndColors.summary.length != 0) {
            odd.select(metalsAndColors.summary[0].toString());
            even.select(metalsAndColors.summary[1].toString());
        }

        if(!metalsAndColors.color.isEmpty()) {
            color.select(metalsAndColors.color);
        }

        if(!metalsAndColors.metals.isEmpty()) {
            metal.select(metalsAndColors.metals);
        }

        salad.clear();
        if(metalsAndColors.vegetables != null) {
            salad.check(metalsAndColors.vegetables);
        }

        submit.click();
    }
}
