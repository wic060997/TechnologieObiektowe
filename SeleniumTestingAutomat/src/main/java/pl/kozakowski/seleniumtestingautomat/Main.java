package pl.kozakowski.seleniumtestingautomat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://www.demotywatory.pl/");
        System.out.println(driver.getTitle());
        driver.close();

        

    }
}
