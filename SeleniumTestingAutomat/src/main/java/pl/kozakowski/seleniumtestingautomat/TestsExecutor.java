package pl.kozakowski.seleniumtestingautomat;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

public class TestsExecutor {

    private Set<Class<? extends PageFactory>> classes;
    private Set<Configuration.BROWSER> browsers;
    private Set<PageFactory> pageFactories = new TreeSet<>();
    private ReportGenerator reportGenerator;

    public TestsExecutor(Set<Class<? extends PageFactory>> classes, Set<Configuration.BROWSER> browsers, ReportGenerator reportGenerator) {
        this.classes = classes;
//        Constructor<PageFactory> pageFactoryConstructor;
//        for (Class<? extends PageFactory> c : classes) {
//            try {
//                pageFactoryConstructor = (Constructor<PageFactory>) c.getConstructor();
//                pageFactories.add(pageFactoryConstructor.newInstance());
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
        this.browsers = browsers;
        this.reportGenerator = reportGenerator;
    }

    public void registerClass(Class<? extends PageFactory> clasz) {
        try {
            Constructor<PageFactory> pageFactoryConstructor = (Constructor<PageFactory>) clasz.getConstructor();
            pageFactories.add(pageFactoryConstructor.newInstance());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }

    public void executeTests() {
        Object o;
        Class clasz;
        WebDriver driver;
        Constructor<WebDriver> webDriverConstructor;
        Method driverMethod;
        Method setupMethod;

        System.out.println("Lista technologi do testów: " + pageFactories);
        for (PageFactory pageFactory : pageFactories) {
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
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e ) {
                    e.printStackTrace();
                    break;
                }

                for (int i = 0; i < Configuration.AMOUNT_OF_TESTS; i++) {
                    executeTestSimpleTech(pageFactory, browser);
                }

            }
        }

    }

    private void executeTestSimpleTech(PageFactory pageFactory, Configuration.BROWSER browser) {
        reportGenerator.addStaticTableTestResult(pageFactory.getTechnology(), browser, pageFactory.performDynamicDataTest());
    }

}
