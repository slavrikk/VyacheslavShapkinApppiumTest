package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
  WebElement signInBtn;

  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
  WebElement registerBtn;

  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
  WebElement inputLogin;

  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
  WebElement inputPassword;

  RegisterPage registerPage;
  BudgetPage budgetPage;

  public NativePageObject(AppiumDriver appiumDriver) {
    PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    registerPage = new RegisterPage(appiumDriver);
    budgetPage = new BudgetPage(appiumDriver);
  }

  public RegisterPage getRegisterPageObject() {
    return registerPage;
  }
}
