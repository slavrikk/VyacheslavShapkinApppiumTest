package scenarios;

import bean.DataBean;
import org.testng.annotations.Test;
import pageObjects.BudgetPage;
import pageObjects.RegisterPage;
import setup.BaseTest;
import setup.DataProvider;
import setup.TypePage;

import static org.assertj.core.api.Assertions.assertThat;

public class nativeMobileTests extends BaseTest {


      /*
      On the decision of bonus task, I chose the solution of comparing screenshots until and after click on button.
      I have found this on the appium documentation (https://appium.io/docs/en/writing-running-appium/image-comparison/)
      But this method required additional npm module as 'opencv4nodejs'. I have installed it but the exception is appearing anyway.
      Could you clarify, this decision is convenient or not?
       */


    @Test(priority = 1, groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getWelement("signInBtn").click();
        /*
        byte[] screenshot1 = Base64.encodeBase64(getDriver().getScreenshotAs(OutputType.BYTES));

        getPo().getWelement("signInBtn").click();

        byte[] screenshot2 = Base64.encodeBase64(getDriver().getScreenshotAs(OutputType.BYTES));

        SimilarityMatchingResult result = getDriver()
                .getImagesSimilarity(screenshot1, screenshot2, new SimilarityMatchingOptions()
                        .withEnabledVisualization());


        assertThat(result.getVisualization().length).isGreaterThan(0);
        assertThat(result.getScore()).isGreaterThan(0.0);

         */
        System.out.println("Simplest Android native test done");

    }


    @Test(priority = 2,
            groups = {"native"},
            description = "Register and Login assert",
            dataProviderClass = DataProvider.class,
            dataProvider = "data")
    public void registerAndLoginTest(DataBean data) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("registerBtn").click();
        RegisterPage registerPage = (RegisterPage) getPo().getPage(TypePage.NATIVE, "registerPage");
        registerPage.register(data.getEmail(), data.getUserName(), data.getPassword());
        getPo().getWelement("inputLogin").sendKeys(data.getEmail());
        getPo().getWelement("inputPassword").sendKeys(data.getPassword());
        getPo().getWelement("signInBtn").click();
        BudgetPage budgetPage = (BudgetPage) getPo().getPage(TypePage.NATIVE, "budgetPage");

        String actual = budgetPage.getBudgetActivity().getText();

        assertThat(actual).isEqualTo(budgetPage.getHeader());
        assertThat(budgetPage.getBudgetActivity().isEnabled()).isEqualTo(true);

        System.out.println("Register and Login assert native test done");
    }

}
