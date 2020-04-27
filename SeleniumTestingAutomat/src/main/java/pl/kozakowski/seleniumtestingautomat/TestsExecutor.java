package pl.kozakowski.seleniumtestingautomat;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class TestsExecutor {

    private Set<Class<? extends PageFactory>> classes;
    private Set<Configuration.BROWSER> browsers;
    private ReportGenerator reportGenerator;

    public TestsExecutor(Set<Class<? extends PageFactory>> classes, Set<Configuration.BROWSER> browsers, ReportGenerator reportGenerator) {
        this.classes = classes;
        this.browsers = browsers;
        this.reportGenerator = reportGenerator;
    }

    public void registerClass(Class<? extends PageFactory> clasz) {
        classes.add(clasz);
    }

    public void executeTests() {
        Object o;
        Class clasz;
        WebDriver driver;
        Constructor<WebDriver> webDriverConstructor;
        PageFactory pageFactory = null;
        Constructor<PageFactory> pageFactoryConstructor;
        Method driverMethod;
        Method setupMethod;

        System.out.println("Lista technologi do testów: " + classes);
        for (Class<? extends PageFactory> pageFactoryClass : classes) {
            for (Configuration.BROWSER browser : browsers) {
                // create WebDriver instance
                // execute simple test

                try {
                    clasz = Class.forName("io.github.bonigarcia.wdm.WebDriverManager");
                    driverMethod = clasz.getMethod(browser.webDriverManagerMethod);
                    setupMethod = clasz.getMethod("setup");
                    o = driverMethod.invoke(null);
                    setupMethod.invoke(o);
                    clasz = Class.forName(browser.webDriverClass);
                    webDriverConstructor = clasz.getConstructor();
                    driver = webDriverConstructor.newInstance();

                    try {
                        pageFactoryConstructor = (Constructor<PageFactory>) pageFactoryClass.getConstructor(WebDriver.class);
                        pageFactory = pageFactoryConstructor.newInstance(driver);
                    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e ) {
                    e.printStackTrace();
                    break;
                }

                for (int i = 0; i < Configuration.AMOUNT_OF_TESTS; i++) {
                    executeTestSimpleTech(pageFactory, browser);
                }
                driver.close();
            }
        }
    }

    private void executeTestSimpleTech(PageFactory pageFactory, Configuration.BROWSER browser) {
        reportGenerator.addStaticTableTestResult(pageFactory.getTechnology(), browser, pageFactory.performStaticTableTest());
    }

}
