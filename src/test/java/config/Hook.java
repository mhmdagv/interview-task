package config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@RequiredArgsConstructor
public class Hook {
    private final DriverConfig driverConfig;

    @Before
    public void beforeTest(){
        driverConfig.initialize();
        driverConfig.getDriver().manage().window().maximize();
    }


    @After
    public void afterTest(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driverConfig.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/jpeg", "screen");
        }
        driverConfig.kill();
    }


}
