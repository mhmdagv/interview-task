package model;

import exception.DuplicateElementKeyException;
import exception.NoSuchLocatorTypeException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ElementInfoMap {
    private ConcurrentMap<String, ElementInfo> elementMapList = new ConcurrentHashMap<>();

    public ConcurrentMap<String, ElementInfo> getMap(){
        return elementMapList;
    }

    public void put(ElementInfo element){
        checkDuplication(element);
        mapToBy(element);
        elementMapList.put(element.getKey(), element);
    }

    public void checkDuplication(ElementInfo element) {
        Set<String> keySet = elementMapList.keySet();

        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if(s.equals(element.getKey())) throw new DuplicateElementKeyException("There is duplicate element in your json (element: "+s+")");
        }
    }

    public void mapToBy(ElementInfo element){
            By by = null;
            if(element == null) throw new NoSuchElementException("Please define your element's json as requirements ");
            switch (element.getType()) {
                case "css":
                    by = By.cssSelector(element.getValue());
                    break;
                case ("name"):
                    by = By.name(element.getValue());
                    break;
                case "id":
                    by = By.id(element.getValue());
                    break;
                case "xpath":
                    by = By.xpath(element.getValue());
                    break;
                case "linkText":
                    by = By.linkText(element.getValue());
                    break;
                case ("partialLinkText"):
                    by = By.partialLinkText(element.getValue());
                    break;
                default: throw new NoSuchLocatorTypeException("No such locator type as "+element.getType()+"");
            }
            element.setLocator(by);
        }



    public ElementInfo get(String s) {
        return elementMapList.get(s);
    }
}
