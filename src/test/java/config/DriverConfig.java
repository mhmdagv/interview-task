package config;

import lombok.Data;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

@Data
public class DriverConfig {

    private ChromeDriver driver;

    public void initialize(){
        if(Objects.isNull(this.driver)) {
            this.driver = new ChromeDriver(new ChromeOptions());
        }
    }

    public void kill(){
        driver.quit();
        this.driver = null;
    }

}
