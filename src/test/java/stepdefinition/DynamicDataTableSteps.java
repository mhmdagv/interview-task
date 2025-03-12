package stepdefinition;

import config.DriverConfig;
import io.cucumber.java.en.Then;
import model.ElementInfoMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import static enums.ExpectedConditionType.VISIBLE;

public class DynamicDataTableSteps extends BaseMethods {
    private static final Logger logger = LogManager.getLogger(BaseSteps.class);


    public DynamicDataTableSteps(ElementInfoMap elementInfoMap, DriverConfig driverConfig) {
        super(elementInfoMap, driverConfig);
    }

    @Then("Column {string} should be sorted correctly")
    public void checkIfColumnSorted(String key){
        List<WebElement> elementList = findElements(key, VISIBLE);
        List<String> actualValueList = elementList.stream().map(WebElement::getText).toList();
        List<String> expectedValueList = actualValueList.stream().sorted().toList();
        Assert.assertEquals(actualValueList, expectedValueList);
    }


    @Then("{string} should be sorted correctly")
    public void checkIfNumberColumnSorted(String key){
        List<WebElement> elementList = findElements(key, VISIBLE);
        List<Double> actualValueList = elementList.stream().map(element
                -> Double.valueOf(element.getText().substring(1)))
                .toList();
        List<Double> expectedValueList = actualValueList.stream().sorted().toList();
        Assert.assertEquals(actualValueList, expectedValueList);

    }
}
