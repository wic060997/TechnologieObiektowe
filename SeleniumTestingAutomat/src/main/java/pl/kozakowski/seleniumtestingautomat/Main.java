package pl.kozakowski.seleniumtestingautomat;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
        browsers.add(Configuration.BROWSER.FIREFOX);
//        browsers.add(Configuration.BROWSER.EDGE);
//        browsers.add(Configuration.BROWSER.IE);
//        browsers.add(Configuration.BROWSER.OPERA);

        TestsExecutor testsExecutor = new TestsExecutor(technologyClassExtractor.getInstalledTechnologyClasses(), browsers, reportGenerator);
        testsExecutor.executeTests();
        reportGenerator.printReport();
    }
}
