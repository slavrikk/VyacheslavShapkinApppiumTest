package scenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.GooglePage;
import setup.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class webMobileTests extends BaseTest {


    @Test(priority = 1, groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {

        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }



    @Test(priority = 2, groups = {"web"}, description = "Make sure that we've searched EPAM in google and result is not empty list")
    public void googleEpamTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, InterruptedException {

      GooglePage googlePage =  getPo().getGooglePage("googlePage");

      googlePage.open();

      googlePage.getInputField().sendKeys("EPAM");
      googlePage.getInputField().sendKeys(Keys.ENTER);

       assertThat(googlePage.getFoundInformation()).isNotEmpty();

    }

}
