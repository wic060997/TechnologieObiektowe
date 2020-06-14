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

    public void executeTests() throws InterruptedException {
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
            System.out.println(pageFactoryClass.getCanonicalName());
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

                for (Configuration.TEST_TYPE testType: Configuration.TEST_TYPE.values()) {
                    if(testType != Configuration.TEST_TYPE.CRUD_ADD && testType != Configuration.TEST_TYPE.CRUD_DELETE && testType != Configuration.TEST_TYPE.CRUD_EDIT){
                        System.out.println(testType);
                        for (int i = 0; i < Configuration.AMOUNT_OF_TESTS ; i++) {
                            switch (testType) {
                                case STATIC_DATA: reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performStaticDataTest()); break;//Thread.sleep(2000); break;
                                case STATIC_TABLE: reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performStaticTableTest()); break;//Thread.sleep(2000); break;
                                case DYNAMIC_TABLE_1: reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._1DATA)); break;
                                case DYNAMIC_TABLE_1k: reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._1kDATA)); break;
                                case DYNAMIC_TABLE_3k:reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._3kDATA)); break;
                                case DYNAMIC_TABLE_5k:reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._5kDATA)); break;
                                case DYNAMIC_TABLE_10k: reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._10kDATA)); break;
                                case DYNAMIC_TABLE_20k:reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._20kDATA)); break;
                                case DYNAMIC_TABLE_50k:reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._50kDATA)); break;
                                case DYNAMIC_TABLE_1m: reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._1MDATA)); break;
                                case DYNAMIC_TABLE_3m:reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._3MDATA)); break;
                                case DYNAMIC_TABLE_5m:reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._5MDATA)); break;
                                case DYNAMIC_TABLE_10m:reportGenerator.addTestResult(testType, pageFactory.getTechnology(), browser, pageFactory.performDynamicTableTest(Configuration.AMOUNT_DATA._10MDATA)); break;
                                case CRUD_DATA: reportGenerator.addTestResultList(testType,pageFactory.getTechnology(),browser,pageFactory.performCrudElements()); break;
                            }
                        }
                    }

                }
                driver.close();
            }
        }
    }
}
