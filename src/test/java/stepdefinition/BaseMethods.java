package stepdefinition;

import config.DriverConfig;
import enums.ExpectedConditionType;
import lombok.RequiredArgsConstructor;
import model.ElementInfo;
import model.ElementInfoMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

@RequiredArgsConstructor
public class BaseMethods {
    protected final ElementInfoMap elementInfoMap;
    protected final DriverConfig driverConfig;

    /**
     * Returns a web element based on the provided JSON key and element wait type.
     *
     * @param key  JSON element key.
     * @param type Element wait type.
     * @return WebElement corresponding to the specified JSON key.
     */
    public WebElement findElement(String key , ExpectedConditionType type){
        ElementInfo elementInfo = elementInfoMap.get(key);
        explicitWait(elementInfo.getLocator(), type, elementInfo.getTime());
        return driverConfig.getDriver().findElement(elementInfo.getLocator());
    }

    public By findBy(String key){
        ElementInfo elementInfo =elementInfoMap.get(key);
        return elementInfo.getLocator();
    }

    /**
     * Returns a web elements based on the provided JSON key and element wait type.
     *
     * @param key  JSON element key.
     * @param type Element wait type.
     * @return WebElement corresponding to the specified JSON key.
     */
    public List<WebElement> findElements(String key , ExpectedConditionType type){
        ElementInfo elementInfo =elementInfoMap.get(key);
        explicitWait(elementInfo.getLocator(), type, elementInfo.getTime());
        return driverConfig.getDriver().findElements(elementInfo.getLocator());
    }

    /**
     * Waits for a web element based on the specified locator, ExpectedConditionType, and time.
     *
     * @param locator The locator of the desired element to wait for.
     * @param type    Expected condition type for the element.
     * @param time    The duration to wait for the element to meet the specified condition.
     */

    protected void explicitWait(By locator, ExpectedConditionType type, int time) {
        WebDriverWait wait = new WebDriverWait(driverConfig.getDriver(), Duration.ofSeconds(time));
        switch (type) {
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case INVISIBLE:
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                break;
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            case PRESENCE:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
            default:
                throw new IllegalArgumentException("Unexpected ExpectedConditionType: " + type);

        }
    }
}
