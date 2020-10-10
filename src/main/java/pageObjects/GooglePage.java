package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage implements Page {

  @FindBy(xpath = "//input[@name='q']")
  private WebElement inputField;

  @FindBy(xpath = "//div[@id='rso']//following-sibling::*")
  private List<WebElement> foundInformation;

  AppiumDriver appiumDriver;

  public GooglePage(AppiumDriver appiumDriver) {

    PageFactory.initElements(appiumDriver, this);

    this.appiumDriver = appiumDriver;
  }

  public void open() {
    appiumDriver.get("https://www.google.com/");
  }

  public WebElement getInputField() {
    return inputField;
  }

  public List<WebElement> getFoundInformation() {
    return foundInformation;
  }
}
