package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BudgetPage implements Page {

  @AndroidFindBy(
      xpath =
          "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
  WebElement budgetActivity;

  @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
  WebElement addExpenseBtn;

  private final String header = "BudgetActivity";

  public BudgetPage(AppiumDriver appiumDriver) {
    PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
  }

  public WebElement getBudgetActivity() {
    return budgetActivity;
  }

  public WebElement getAddExpenseBtn() {
    return addExpenseBtn;
  }

  public String getHeader() {
    return header;
  }
}
