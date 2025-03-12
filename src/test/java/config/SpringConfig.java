package config;

import model.ElementInfoMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import utility.JsonReadUtils;

@Configuration
@ComponentScan(basePackages = {"stepdefinition"})
public class SpringConfig {

    @Bean
    public DriverConfig driverConfig() {
        return new DriverConfig();
    }

    @Bean
    public ElementInfoMap elementInfoMap() {
        ElementInfoMap elementInfoMap = new ElementInfoMap();
        JsonReadUtils.readAllJsonElements(elementInfoMap, "jsonpom");
        return elementInfoMap;
    }
}
