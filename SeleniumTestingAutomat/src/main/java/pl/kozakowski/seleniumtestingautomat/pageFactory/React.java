package pl.kozakowski.seleniumtestingautomat.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kozakowski.seleniumtestingautomat.Configuration;
import pl.kozakowski.seleniumtestingautomat.PageFactory;

import java.util.concurrent.TimeUnit;

public class React implements PageFactory {

    private static final String BASE_URL = "http://localhost:3000";

    private static final String TABLE_DATA = "/table";
    private static final String DYNAMIC_DATA = "/dynamic-table";
    private static final String TEXT_DATA = "/text";
    private static final String STATIC_TABLE_ENTRY_BTN_XPATH = "//*[@id=\"wrap-container-main-table\"]/a[1]";

    private  static final Configuration.TECHNOLOGY technology = Configuration.TECHNOLOGY.REACT;

    private WebDriver webDriver;
    private WebDriverWait wait;

    public React(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = (WebDriverWait) new WebDriverWait(this.webDriver, 30).pollingEvery(10, TimeUnit.MILLISECONDS);
    }

    @Override
    public Integer performStaticDataTest() {
        return null;
    }

    @Override
    public Integer performStaticTableTest() {

        Long startTime;
        Long stopTime;
        // przejdź do /table
        // kliknij "Dane w tabeli statyczne"
        // Zacznij liczyć
        // Wyszukaj widoczne "rverekerrr@about.com"
        // Zegar stop
        // Zwróć różnice

        webDriver.get(BASE_URL+TABLE_DATA);
        WebElement staticTableBtn = webDriver.findElement(By.xpath(STATIC_TABLE_ENTRY_BTN_XPATH));
        staticTableBtn.click();
        startTime = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/table/tbody/tr[3000]/td[6]")));

        stopTime = System.currentTimeMillis();

        return Math.toIntExact(stopTime - startTime);
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
}
