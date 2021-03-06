package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import entities.MetalsAndColors;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class ResultsSection extends Form {
    @FindBy(css = ".results li")
    public Elements<Label> results;

    public void checkResults(MetalsAndColors metalsAndColors) {
        SoftAssert softAssert = new SoftAssert();
        String regexColor = String.format("%s: %s", "Color", metalsAndColors.color);
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexColor)), "Wrong Color");

        if (metalsAndColors.summary.length != 0) {
            Integer sum = metalsAndColors.summary[0] + metalsAndColors.summary[1];
            String regexSum = String.format("%s: %s", "Summary", sum);
            softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexSum)), "Wrong Summary");
        }

        String regexMetal = String.format("%s: %s", "Metal", metalsAndColors.metals);
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexMetal)), "Wrong Metal");

        String elements = String.join(", ", metalsAndColors.elements);
        String regexElement = String.format("%s: %s", "Elements", elements);
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexElement)), "Wrong Elements");

        String salads = String.join(", ", metalsAndColors.vegetables);
        String regexSalad = String.format("%s: %s", "Vegetables", salads);
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexSalad.trim())), "Wrong Vegetables");
        softAssert.assertAll();
    }
}
