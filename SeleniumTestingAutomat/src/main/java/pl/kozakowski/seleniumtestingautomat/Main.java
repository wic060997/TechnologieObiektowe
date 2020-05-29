package pl.kozakowski.seleniumtestingautomat;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        // Option extractor
        // pageFactory extraction - done
        // TestExecutor
        // ReportGenerator

        System.setProperty("webdriver.chrome.silentOutput", "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        TechnologyClassExtractor technologyClassExtractor = new TechnologyClassExtractor();
        ReportGenerator reportGenerator = new ReportGenerator();

        System.out.println(technologyClassExtractor.getInstalledTechnologyClasses());
        Set<Configuration.BROWSER> browsers = new TreeSet<>();
        browsers.add(Configuration.BROWSER.CHROME);
//        browsers.add(Configuration.BROWSER.FIREFOX);
//        browsers.add(Configuration.BROWSER.EDGE);
//        browsers.add(Configuration.BROWSER.IE);
//        browsers.add(Configuration.BROWSER.OPERA);

        TestsExecutor testsExecutor = new TestsExecutor(technologyClassExtractor.getInstalledTechnologyClasses(), browsers, reportGenerator);
        try {
            testsExecutor.executeTests();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reportGenerator.printReport();
    }
}
