package config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import lombok.RequiredArgsConstructor;
import model.ElementInfoMap;
import org.testng.annotations.BeforeClass;
import utility.JsonReadUtils;

@RequiredArgsConstructor
public class Hook {
    private final DriverConfig driverConfig;

    @Before
    public void beforeTest(){
        driverConfig.initialize();
    }


    @After
    public void afterTest(){
        driverConfig.kill();
    }

}
