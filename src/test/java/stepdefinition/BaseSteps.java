package stepdefinition;

import config.DriverConfig;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import model.ElementInfoMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static enums.ExpectedConditionType.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseSteps extends BaseMethods {
    private static final Logger logger = LogManager.getLogger(BaseSteps.class);


    public BaseSteps(ElementInfoMap elementInfoMap, DriverConfig driverConfig) {
        super(elementInfoMap, driverConfig);
    }

    /**
     * Converts the provided string key into an element based on your JSON file and clicks it.
     *
     * @param key Your element key.
     */
    @And("Click on the {string} element")
    public void clickByKey(String key){
        try{
            findElement(key, CLICKABLE).click();
        }catch(Exception e){
            ((JavascriptExecutor)(driverConfig.getDriver())).executeScript("arguments[0].click();", findElement(key , VISIBLE));
        }
    }

    /**
     * Navigates the driver to the given link.
     *
     * @param link Site link.
     */
    @Given("Navigate to {string}")
    public void get(String link) {
        driverConfig.getDriver().get(link);
    }

    /**
     * Fills the input field associated with the provided JSON element using the specified text.
     *
     * @param key  JSON element.
     * @param text Text to be filled.
     */
    @When("Fill the {string} field with {string}")
    public void userFillsField(String key, String text){
        findElement(key, VISIBLE).sendKeys(text);
    }

    /**
     * Fills the specified field identified by the given locator with the provided text using keyboard actions.
     *
     * @param key The locator for the field to be filled.
     * @param text The text to be entered into the field.
     */
    @When("Fill the {string} field with {string} by keyboard actions")
    public void userFillsFieldByActions(String key, String text){
        Actions actions = new Actions(driverConfig.getDriver());
        actions.sendKeys(findElement(key, VISIBLE), text).perform();
    }

    /**
     * Verifies whether the expected message is displayed inside the specified JSON element.
     *
     * @param key      JSON element.
     * @param message  Expected message.
     */
    @Then("Verify that message {string} is displayed inside {string}")
    public void inputErrorMessageShouldBeDisplayed(String message, String key){
        Assert.assertEquals(findElement(key, VISIBLE).getText(), message);
    }

    /**
     * Verifies whether the specified JSON element is displayed on the page.
     *
     * @param page Page that should be displayed (this parameter is for the step name).
     * @param key  JSON element.
     */
    @Then("Verify that the user is navigated to {string} page {string}")
    public void userShouldBeNavigatedTo(String page, String key ) {
        Assert.assertTrue(findElement(key, VISIBLE).isDisplayed());
    }

    /**
     * Checks whether the text of the specified JSON element contains the expected text.
     *
     * @param key           JSON element.
     * @param expectedText  Text to be contained.
     */
    @Then("Verify that element {string} contains text {string}")
    public void verifyElementContainsText(String key, String expectedText){
        String actualText = findElement(key, VISIBLE).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    /**
     * Checks whether the text of the specified JSON element have the expected text.
     *
     * @param key           JSON element.
     * @param expectedText  Text to be equal.
     */
    @Then("Verify that element {string} have text {string}")
    public void verifyElementHaveText(String key, String expectedText){
        String actualText = findElement(key, VISIBLE).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    /**
     * Verifies that the specified element becomes invisible within a given time frame.
     *
     * @param key The locator for the element to be verified.
     * @param time The maximum time, in seconds, to wait for the element to become invisible.
     */
    @Then("Verify that element {string} invisible in {int} seconds")
    public void verifyElementInvisible(String key, int time){
        explicitWait(findBy(key) , INVISIBLE , time);
    }

    @Then("Verify that element {string} displayed")
    public void verifyElementDisplay(String key){
        Assert.assertTrue(findElement(key , VISIBLE).isDisplayed());
    }
    /**
     * Checks whether the specified JSON element is disabled.
     *
     * @param key JSON element.
     */
    @Then("Verify that element {string} is disabled")
    public void checkDisabledBtn(String key){
        Assert.assertFalse(findElement(key, VISIBLE).isEnabled());
    }

    /**
     * Checks whether the specified JSON element is enabled.
     *
     * @param key JSON element.
     */
    @Then("Verify that element {string} is enabled")
    public void checkEnabledBtn(String key){
        Assert.assertTrue(findElement(key, VISIBLE).isEnabled());
    }
    /**
     * Verifies that the current URL contains the expected value.
     *
     * @param expectedURL The expected value that the current URL should contain.
     */
    @And("Verify that the current URL contains the value {string}")
    public void verifyCurrentURLContainsValue(String expectedURL) {
        String actualURL = driverConfig.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL != null && actualURL.contains(expectedURL));
    }
    /**
     * Simulates pressing a specified key on the keyboard after locating a specific element.
     *
     * @param key JSON element key.
     * @param keyboardKey The keyboard key to press (e.g., "ENTER", "TAB", "ESCAPE").
     */
    @And("Press the {string} key for the element {string}")
    public void pressSpecifiedKeyForElement(String keyboardKey, String key) {
        keyboardKey = keyboardKey.toUpperCase();
        try {
            Keys specialKey = Keys.valueOf(keyboardKey);
            findElement(key,VISIBLE).sendKeys(specialKey);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unsupported keyboard key: " + keyboardKey);
        }
    }

    /**
     * Pauses the test execution for the specified number of seconds.
     *
     * @param second The number of seconds to wait.
     */
    @Then("Wait for {int} second")
    public void secondsWait(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clicks on the specified text within a list of elements.
     *
     * @param text The text to be clicked.
     * @param key The locator for the elements.
     */
    @When("Click {string} text inside {string} elements")
    public void clickFromElements(String text , String key){
        List<WebElement> list = findElements(key , VISIBLE);
        for(WebElement element: list){
            if(element.getText().contains(text)){
                element.click();
                break;
            }
        }
    }

    @When("Log the table {string} column")
    public void clickFromElements(String key){
        List<WebElement> elements = findElements(key, VISIBLE);
        for (WebElement element : elements) {
            logger.info(element.getText());
        }
        }


    /**
     * Uploads a file to the specified element from a given file path.
     *
     * @param key The locator for the element to upload the file to.
     * @param path The relative path of the file to be uploaded, starting from the root directory.
     */
    @When("Upload a file to the {string} element from the specified {string} path")
    public void uploadFile(String key, String path){
        findElement(key, VISIBLE).sendKeys(System.getProperty("user.dir") + path);
    }


    /**
     * Drags an element and drops it onto another specified element.
     *
     * @param sourceKey  JSON element of the source element to be dragged.
     * @param targetKey  JSON element of the target element where the source should be dropped.
     */
    @When("Drag the {string} element and drop it onto {string}")
    public void dragAndDropElement(String sourceKey, String targetKey) {
        WebElement sourceElement = findElement(sourceKey, VISIBLE);
        WebElement targetElement = findElement(targetKey, VISIBLE);

        Actions actions = new Actions(driverConfig.getDriver());
        actions.scrollToElement(sourceElement).perform();
        actions.scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(sourceElement), 0 , 200).perform();
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

}





