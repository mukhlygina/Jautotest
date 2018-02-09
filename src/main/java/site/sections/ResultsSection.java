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
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexColor)), String.format("Wrong Color"));

        Integer sum = metalsAndColors.even + metalsAndColors.odd;
        String regexSum = String.format("%s: %s", "Summary", sum);
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexSum)), String.format("Wrong Summary"));

        String regexMetal = String.format("%s: %s", "Metal", metalsAndColors.metal);
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexMetal)), String.format("Wrong Metal"));

        String elements = String.join(", ", metalsAndColors.element);
        String regexElement = String.format("%s: %s", "Elements", elements);
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexElement)), String.format("Wrong Elements"));

        String salads = String.join(", ", metalsAndColors.salad);
        String regexSalad = String.format("%s: %s", "Vegetables", salads);
        softAssert.assertTrue(results.stream().anyMatch(row -> row.getText().matches(regexSalad)), String.format("Wrong Vegetables"));
        softAssert.assertAll();
    }
}
