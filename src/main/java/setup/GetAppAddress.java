package setup;

import bean.AppAddressBean;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GetAppAddress {

  private static final String APK = ".apk";
  private static final String IPA = ".ipa";

  private GetAppAddress() {}

  public static String getAddress(String nameApp) throws IOException, InterruptedException {
    Runtime runtime = Runtime.getRuntime();
    String absPath = new File("").getAbsolutePath() + "/src/main/resources/" + nameApp;
    String fileString = absPath.substring(2);
    String url =
        "curl -u \""
            + System.getProperty("login")
            + ":"
            + System.getProperty("token")
            + "\" -X POST \"https://api-cloud.browserstack.com/app-automate/upload\" "
            + "-F \"file=@"
            + fileString
            + "\"";

    Process process = runtime.exec(url);

    String result = IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8);

    Gson gson = new Gson();
    AppAddressBean appAddressBean = gson.fromJson(result, AppAddressBean.class);

    return appAddressBean.getApp_url();
  }
}
