//package pl.kozakowski.seleniumtestingautomat.pageFactory;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import pl.kozakowski.seleniumtestingautomat.Configuration;
//import pl.kozakowski.seleniumtestingautomat.PageFactory;
//
//import java.util.concurrent.TimeUnit;
//
//public class Angular extends PageFactory {
//
//    private static final String BASE_URL = "http://localhost:3000";
//
//    private static final String TABLE_DATA = "/table";
//    private static final String DYNAMIC_DATA = "/dynamic-table";
//    private static final String TEXT_DATA = "/text";
//
//    public Angular(WebDriver webDriver) {
//        technology = Configuration.TECHNOLOGY.ANGULAR;
//        this.webDriver = webDriver;
//        wait = (WebDriverWait) new WebDriverWait(this.webDriver, 30).pollingEvery(10, TimeUnit.MILLISECONDS);
//    }
//
//    @Override
//    public Integer performStaticDataTest() {
//        return null;
//    }
//
//    @Override
//    public Integer performStaticTableTest() {
//        return null;
//    }
//
//    @Override
//    public Integer performDynamicDataTest() {
//        return null;
//    }
//
//    @Override
//    public Integer performDynamicTableTest(Configuration.AMOUNT_DATA amount_data) {
//        return null;
//    }
//}
