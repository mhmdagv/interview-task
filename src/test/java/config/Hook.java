package config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.RequiredArgsConstructor;
import model.ElementInfoMap;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import utility.JsonReadUtils;

import java.io.ByteArrayInputStream;

@RequiredArgsConstructor
public class Hook {
    private final DriverConfig driverConfig;

    @Before
    public void beforeTest(){
        driverConfig.initialize();
    }


    @After
    public void afterTest(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driverConfig.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screen" , new ByteArrayInputStream(screenshot));
        }
        driverConfig.kill();
    }

}
