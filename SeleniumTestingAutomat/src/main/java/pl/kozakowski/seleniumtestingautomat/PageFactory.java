package pl.kozakowski.seleniumtestingautomat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageFactory {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public PageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(this.webDriver, 30);
    }

//    protected PageFactory() {
//    }

    public abstract Integer performStaticDataTest();
    public abstract Integer performStaticTableTest();
    public abstract Integer performDynamicDataTest();
    public abstract Integer performDynamicTableTest(Configuration.AMOUNT_DATA amount_data);

    public abstract Configuration.TECHNOLOGY getTechnology();
}
