package pl.kozakowski.seleniumtestingautomat.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kozakowski.seleniumtestingautomat.Configuration;
import pl.kozakowski.seleniumtestingautomat.PageFactory;

public class Vue extends PageFactory {

    private static final String BASE_URL = "http://localhost:8081";

    private static final String TABLE_DATA = "/table";
    private static final String DYNAMIC_DATA = "/dynamic-table";
    private static final String TEXT_DATA = "/text";
    private static final String STATIC_TABLE_ENTRY_BTN_XPATH = "/html/body/div/div/div/a[1]";
    private static final String STATIC_DATA_ENTRY_BTN_XPATH = "/html/body/div/div/div/a[1]";

    public Vue(WebDriver webDriver) {
        technology = Configuration.TECHNOLOGY.VUE;
        this.webDriver = webDriver;
        wait = new WebDriverWait(this.webDriver, 30);
    }

    @Override
    public Integer performStaticDataTest() {
        Integer measuredDelay = 0;

        webDriver.get(BASE_URL);
        WebElement staticDataBtn = webDriver.findElement(By.xpath(STATIC_DATA_ENTRY_BTN_XPATH));
        staticDataBtn.click();
        do {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            measuredDelay = analyzeLog();
        } while (measuredDelay == 0);
        return measuredDelay;
    }

    @Override
    public Integer performStaticTableTest() {
        Integer measuredDelay = 0;
        webDriver.get(BASE_URL+TABLE_DATA);
        WebElement staticTableBtn = webDriver.findElement(By.xpath(STATIC_TABLE_ENTRY_BTN_XPATH));
        staticTableBtn.click();
        do {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            measuredDelay = analyzeLog();
        } while (measuredDelay == 0);
        return measuredDelay;
    }

    @Override
    public Integer performDynamicDataTest() {
        return null;
    }

    @Override
    public Integer performDynamicTableTest(Configuration.AMOUNT_DATA amount_data) {
        return null;
    }
}
