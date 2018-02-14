package ex8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.MetalsAndColors;
import entities.User;
import enums.MenuEnum;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import site.JDISite;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataProviderTest extends TestNGBase {
    @SneakyThrows
    @DataProvider
    public Object[][] dataProvider() {
        String filePath = getClass().getClassLoader().getResource("ex8_jdi_metalsColorsDataSet.json").getFile();
        File jfile = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<String, MetalsAndColors>> typeRef = new TypeReference<HashMap<String, MetalsAndColors>>() {
        };
        HashMap<String, MetalsAndColors> valuesFromJson = objectMapper.readValue(jfile, typeRef);

        return convertMapToArray(valuesFromJson);
    }

    public Object[][] convertMapToArray(Map<String, MetalsAndColors> map) {
        Object[][] data = new Object[map.size()][];
        Object[] values = map.values().toArray();
        for (int i = 0; i < values.length; i++) {
            data[i] = new Object[]{values[i]};
        }
        return data;
    }

    @BeforeSuite
    public void setUp() {
        WebSite.init(JDISite.class);
    }

    @BeforeClass
    public void login() {
        JDISite.indexPage.open();
        JDISite.login(new User());
    }

    @Test(dataProvider = "dataProvider")
    public void MetalsColorsTest(MetalsAndColors metalsAndColors) {
        JDISite.headerMenu.selectMenu(MenuEnum.METALS_COLORS);
        JDISite.metalsColorsPage.elementsForm.fillAndSubmitForm(metalsAndColors);
        JDISite.metalsColorsPage.resultsSection.checkResults(metalsAndColors);
    }
}
