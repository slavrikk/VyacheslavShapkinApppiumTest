package setup;

import org.openqa.selenium.WebElement;
import pageObjects.BudgetPage;
import pageObjects.GooglePage;
import pageObjects.Pages;
import pageObjects.RegisterPage;


public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    Pages getPage(TypePage typePage, String namePage) throws NoSuchFieldException, IllegalAccessException;

    RegisterPage getNativeRegisterPage(String name) throws NoSuchFieldException, IllegalAccessException;

    BudgetPage getNativeBudgetPage(String name) throws NoSuchFieldException, IllegalAccessException;

    GooglePage getGooglePage(String name) throws NoSuchFieldException, IllegalAccessException;



}
