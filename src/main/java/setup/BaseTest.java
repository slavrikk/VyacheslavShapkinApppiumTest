package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.PageObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static setup.GetAppAddress.*;

public class BaseTest implements IDriver {

  private static AppiumDriver appiumDriver; // singleton
  IPageObject po;

  @Override
  public AppiumDriver getDriver() {
    return appiumDriver;
  }



  public IPageObject getPo() {
    return po;
  }

  @Parameters({
    "platformName",
    "appType",
    "deviceName",
    "browserName",
    "app",
    "device",
    "os_version",
    "realMobile"
  })
  @BeforeClass(alwaysRun = true)
  public void setUp(
      String platformName,
      String appType,
      String deviceName,
      @Optional("") String browserName,
      @Optional("") String app,
      @Optional("") String device,
      @Optional("") String os_version,
      @Optional("") String realMobile)
      throws Exception {
    System.out.println("Before: app type - " + appType);
    setAppiumDriver(platformName, deviceName, browserName, app, device,os_version,realMobile);
    setPageObject(appType, appiumDriver);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    System.out.println("After");
    appiumDriver.closeApp();
  }

  private void setAppiumDriver(
      String platformName, String deviceName, String browserName, String app, String device, String os_version, String realMobile) throws IOException, InterruptedException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    // mandatory Android capabilities
    capabilities.setCapability("platformName", platformName);
    capabilities.setCapability("deviceName", deviceName);

    if (app.startsWith("./src")) {
      capabilities.setCapability("app", (new File(app)).getAbsolutePath());

    } else if( !app.equals("") && !app.startsWith("./src")){
      String appUrl = getAddress(app);
      capabilities.setCapability("app", appUrl);
    }
    capabilities.setCapability("browserName", browserName);
    capabilities.setCapability("device", device);
    capabilities.setCapability("os_version", os_version);
    capabilities.setCapability("realMobile", realMobile);
    capabilities.setCapability("chromedriverDisableBuildCheck", "true");

    try {
        appiumDriver= new AppiumDriver(new URL("https://"
                +System.getProperty("login")+":"
                +System.getProperty("token")+
                "@hub-cloud.browserstack.com/wd/hub"), capabilities);

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    // Timeouts tuning
    appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
    po = new PageObject(appType, appiumDriver);
  }
}
