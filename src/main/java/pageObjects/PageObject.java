package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import setup.IPageObject;
import setup.TypePage;

import java.lang.reflect.Field;

import static setup.TypePage.NATIVE;
import static setup.TypePage.WEB;

public class PageObject implements IPageObject {

    Object somePageObject; // it should be set of web page or EPAM Test App WebElements

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new NativePageObject(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }

    }


    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);

    }

   @Override
   public Pages getPage(TypePage typePage, String namePage) throws NoSuchFieldException, IllegalAccessException {
        if(typePage.equals(NATIVE)){
            Field field = somePageObject.getClass().getDeclaredField(namePage);
            field.setAccessible(true);
            switch (namePage){
                case "registerPage":
                    return (RegisterPage) field.get(somePageObject);
                case "budgetPage":
                    return (BudgetPage) field.get(somePageObject);
                default: throw new NoSuchFieldException();
            }
        }
        else  {
            Field field = somePageObject.getClass().getDeclaredField(namePage);
            field.setAccessible(true);
            switch (namePage){
                case "googlePage":
                    return (GooglePage) field.get(somePageObject);
                default: throw new NoSuchFieldException();
            }
        }
   }

    @Override
    public RegisterPage getNativeRegisterPage(String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = somePageObject.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return (RegisterPage) field.get(somePageObject);
    }

    @Override
    public BudgetPage getNativeBudgetPage(String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = somePageObject.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return (BudgetPage) field.get(somePageObject);
    }

    @Override
    public GooglePage getGooglePage(String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = somePageObject.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return (GooglePage) field.get(somePageObject);
    }


}
