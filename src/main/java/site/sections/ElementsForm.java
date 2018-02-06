package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsAndColors;
import org.openqa.selenium.support.FindBy;

public class ElementsForm extends Form<MetalsAndColors> {
    @FindBy(css = "#elements-checklist label")
    public CheckList element;

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
    public DropList salad;

    @FindBy(css = "#submit-button")
    public Button submit;

}
