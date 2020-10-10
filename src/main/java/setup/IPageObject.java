package setup;

import org.openqa.selenium.WebElement;
import pageObjects.Page;


public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    Page getPage(TypePage typePage, String namePage) throws NoSuchFieldException, IllegalAccessException;

}
