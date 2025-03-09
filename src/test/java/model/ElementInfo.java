package model;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class ElementInfo {
    private String key;
    private String value;
    private String type;
    private int time;
    private By locator;
}
