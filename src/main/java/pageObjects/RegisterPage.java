package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
  WebElement inputEmail;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
  WebElement inputUserName;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
  WebElement inputPassword;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
  WebElement inputPasswordConfirm;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
  WebElement registerBtn;

  public RegisterPage(AppiumDriver appiumDriver) {
    PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
  }

  public void register(String email, String userName, String password) {
    inputEmail.sendKeys(email);
    inputUserName.sendKeys(userName);
    inputPassword.sendKeys(password);
    inputPasswordConfirm.sendKeys(password);
    registerBtn.click();
  }

  public WebElement getInputEmail() {
    return inputEmail;
  }

  public WebElement getInputUserName() {
    return inputUserName;
  }

  public WebElement getInputPassword() {
    return inputPassword;
  }

  public WebElement getInputPasswordConfirm() {
    return inputPasswordConfirm;
  }

  public WebElement getRegisterBtn() {
    return registerBtn;
  }
}
