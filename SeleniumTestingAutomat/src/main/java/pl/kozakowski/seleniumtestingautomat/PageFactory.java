package pl.kozakowski.seleniumtestingautomat;

import org.openqa.selenium.WebDriver;

public interface PageFactory {

    Integer performStaticDataTest();
    Integer performStaticTableTest();
    Integer performDynamicDataTest();
    Integer performDynamicTableTest(Configuration.AMOUNT_DATA amount_data);

    Configuration.TECHNOLOGY getTechnology();
}
