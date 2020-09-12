package setup;

import org.openqa.selenium.WebElement;
import pageObjects.BudgetPage;
import pageObjects.GooglePage;
import pageObjects.RegisterPage;


public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    RegisterPage getNativeRegisterPage(String name) throws NoSuchFieldException, IllegalAccessException;

    BudgetPage getNativeBudgetPage(String name) throws NoSuchFieldException, IllegalAccessException;

    GooglePage getGooglePage(String name) throws NoSuchFieldException, IllegalAccessException;



}
