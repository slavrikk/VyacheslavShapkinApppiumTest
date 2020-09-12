package setup;

import bean.DataBean;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "data")
    public static Object[][] dataProvider() throws FileNotFoundException {
        String absPath = new File("").getAbsolutePath() +
                "/src/main/resources/data.json";
        Gson gson = new Gson();
        DataBean dataBean = gson.fromJson(new FileReader(new File(absPath)), DataBean.class);
        return new Object[][]{{dataBean}};
    }
}
