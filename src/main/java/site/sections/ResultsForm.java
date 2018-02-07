package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import entities.MetalsAndColors;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class ResultsForm extends Form {
    @FindBy(css = ".results li")
    public Elements<Label> results;

    public void checkResults(String name, String condition) {
        String regex = String.format("%s: %s", name, condition);
        // TODO check all data at once or using soft asserts
        assertTrue(results.stream().anyMatch(row -> row.getText().matches(regex)), String.format("Wrong %s", name));
    }

    public void checkForm(MetalsAndColors metalsAndColors) {
        checkResults("Color", metalsAndColors.color);
        checkResults("Metal", metalsAndColors.metal);
        checkResults("Elements", metalsAndColors.element);
        Integer sum = Integer.parseInt(metalsAndColors.even) + Integer.parseInt(metalsAndColors.odd);
        checkResults("Summary", sum.toString());
    }
}
