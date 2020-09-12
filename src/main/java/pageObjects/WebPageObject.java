package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {

  public GooglePage googlePage;

  public WebPageObject(AppiumDriver appiumDriver) {
    PageFactory.initElements(appiumDriver, this);
    googlePage = new GooglePage(appiumDriver);
  }
}
