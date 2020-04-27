package pl.kozakowski.seleniumtestingautomat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.reflections8.Reflections;
import org.reflections8.scanners.ResourcesScanner;
import org.reflections8.scanners.SubTypesScanner;
import org.reflections8.util.ClasspathHelper;
import org.reflections8.util.ConfigurationBuilder;
import org.reflections8.util.FilterBuilder;


import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        // Option extractor
        // pageFactory extraction - done
        // TestExecutor
        // ReportGenerator

        TechnologyClassExtractor technologyClassExtractor = new TechnologyClassExtractor();
        ReportGenerator reportGenerator = new ReportGenerator();

        System.out.println(technologyClassExtractor.getInstalledTechnologyClasses());
        Set<Configuration.BROWSER> browsers = new TreeSet<>();
        browsers.add(Configuration.BROWSER.CHROME);

        TestsExecutor testsExecutor = new TestsExecutor(technologyClassExtractor.getInstalledTechnologyClasses(), browsers, reportGenerator);
        testsExecutor.executeTests();


//        Class clasz;
//        Method method1 = null;
//        Method method2 = null;
//        Object o;
//        Constructor<WebDriver> webDriverConstructor;
//
//        WebDriver driver = null;
//
//        try {
//            clasz = Class.forName("io.github.bonigarcia.wdm.WebDriverManager");
//            method1 = clasz.getMethod("chromedriver");
//            method2 = clasz.getMethod("setup");
//        } catch (ClassNotFoundException | NoSuchMethodException e) {
//            System.out.println("Klasa albo Metoda nie istnieje");
//            e.printStackTrace();
//        }
//
//        try {
//            o = method1.invoke(null);
//            method2.invoke(o);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            clasz = Class.forName("org.openqa.selenium.chrome.ChromeDriver");
//            webDriverConstructor = clasz.getConstructor();
//            driver = webDriverConstructor.newInstance();
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("Klasa nie istnieje");
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//
////        driver = new ChromeDriver();
//        driver.get("https://www.demotywatory.pl/");
//        System.out.println(driver.getTitle());
//        driver.close();



    }
}
