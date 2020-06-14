package pl.kozakowski.seleniumtestingautomat.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kozakowski.seleniumtestingautomat.Configuration;
import pl.kozakowski.seleniumtestingautomat.PageFactory;

import java.util.concurrent.TimeUnit;

public class Angular extends PageFactory {

    private static final String BASE_URL = "http://localhost:4200";

    private static final String TABLE_DATA = "/tableChoose";
    private static final String DYNAMIC_DATA = "/chooseTable";
    private static final String TEXT_DATA = "/text";
    private static final String STATIC_DATA_ENTRY_BTN_XPATH = "/html/body/app-root/app-home-page/div/div/button[1]";
    private static final String START_TEXT = "START TIME: ";
    private static final String STOP_TEXT = "After content checked: ";
    private static final String STATIC_TABLE_ENTRY_BTN_XPATH = "/html/body/app-root/app-table/div/div/button[1]";

    public Angular(WebDriver webDriver) {
        technology = Configuration.TECHNOLOGY.ANGULAR;
        this.webDriver = webDriver;
        wait = (WebDriverWait) new WebDriverWait(this.webDriver, 30).pollingEvery(10, TimeUnit.MILLISECONDS);
    }

    @Override
    public Long performStaticDataTest() {
        Long measuredDelay = 0L;
        webDriver.get(BASE_URL);
        WebElement staticDataBtn = webDriver.findElement(By.xpath(STATIC_DATA_ENTRY_BTN_XPATH));
        staticDataBtn.click();
        do {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            measuredDelay = analyzeLog(START_TEXT, STOP_TEXT);
        } while (measuredDelay < 0);
        if(!(measuredDelay < 1000*60*60*24 && measuredDelay > -1)) measuredDelay = performStaticDataTest();
        return measuredDelay;
    }

    @Override
    public Long performStaticTableTest() {

        Long measuredDelay = 0L;

        webDriver.get(BASE_URL+TABLE_DATA);
        WebElement staticTableBtn = webDriver.findElement(By.xpath(STATIC_TABLE_ENTRY_BTN_XPATH));
        staticTableBtn.click();
        do {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            measuredDelay = analyzeLog(START_TEXT, STOP_TEXT);
        } while (measuredDelay < 0);
        if(!(measuredDelay < 1000*60*60*24 && measuredDelay > -1)) measuredDelay = performStaticTableTest();
        return measuredDelay;
    }

    @Override
    public Long performDynamicTableTest(Configuration.AMOUNT_DATA amount_data) {
        Long measuredDelay = 0L;
        WebElement dynamicTableBtn = null;
        webDriver.get(BASE_URL+DYNAMIC_DATA);
        switch (amount_data) {
            case _1DATA: dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[1]")); break;
            case _1kDATA: dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[2]")); break;
            case _3kDATA: dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[3]")); break;
            case _5kDATA: dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[4]")); break;
            case _10kDATA: dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[5]")); break;
            case _20kDATA: dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[6]")); break;
            case _50kDATA: dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[7]")); break;
            case _1MDATA: dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[8]")); break;
            case _3MDATA:dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[9]")); break;
            case _5MDATA:dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[10]")); break;
            case _10MDATA:dynamicTableBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-choose-table/div/div/button[11]")); break;
        }
        dynamicTableBtn.click();
        do {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            measuredDelay = analyzeLog(START_TEXT, STOP_TEXT);
        } while (measuredDelay < 0);
        if(!(measuredDelay < 1000*60*60*24 && measuredDelay > -1)) {
            measuredDelay = performDynamicTableTest(amount_data);
        }
        return measuredDelay;
    }
}
