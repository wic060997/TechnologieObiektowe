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

import java.util.Date;

public class Vue implements PageFactory {

    private static final String BASE_URL = "http://localhost:8081";

    private static final String TABLE_DATA = "/table";
    private static final String DYNAMIC_DATA = "/dynamic-table";
    private static final String TEXT_DATA = "/text";
    private static final String STATIC_TABLE_ENTRY_BTN_XPATH = "/html/body/div/div/div/a[1]";

    private static final Configuration.TECHNOLOGY technology = Configuration.TECHNOLOGY.VUE;
    private WebDriver webDriver;
    private WebDriverWait wait;

    public Vue(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(this.webDriver, 30);
    }

    @Override
    public Integer performStaticDataTest() {
        return null;
    }

    @Override
    public Integer performStaticTableTest() {
        webDriver.get(BASE_URL+TABLE_DATA);
        WebElement staticTableBtn = webDriver.findElement(By.xpath(STATIC_TABLE_ENTRY_BTN_XPATH));
        staticTableBtn.click();
        return analyzeLog();
    }

    @Override
    public Integer performDynamicDataTest() {
        return null;
    }

    @Override
    public Integer performDynamicTableTest(Configuration.AMOUNT_DATA amount_data) {
        return null;
    }

    @Override
    public Configuration.TECHNOLOGY getTechnology() {
        return technology;
    }

    public Integer analyzeLog() {
        Long startTime = 0L;
        Long stopTime = 0L;
        String temp;
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if(entry.getMessage().contains("Start:")) {
                temp = entry.getMessage();
                temp = String.valueOf(temp.subSequence(temp.indexOf("Start:") + "Start:".length(), temp.length()));
                temp = temp.replace("\"","");
                startTime = Long.parseLong(temp);
            }
            if(entry.getMessage().contains("Stop:")) {
                temp = entry.getMessage();
                temp = String.valueOf(temp.subSequence(temp.indexOf("Stop:") + "Stop:".length(), temp.length()));
                temp = temp.replace("\"","");
                stopTime = Long.parseLong(temp);
            }
        }
        return Math.toIntExact(stopTime - startTime);
    }


}
