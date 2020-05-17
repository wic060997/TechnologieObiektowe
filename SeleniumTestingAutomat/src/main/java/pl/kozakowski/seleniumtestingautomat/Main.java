package pl.kozakowski.seleniumtestingautomat;

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
//        browsers.add(Configuration.BROWSER.FIREFOX);

        TestsExecutor testsExecutor = new TestsExecutor(technologyClassExtractor.getInstalledTechnologyClasses(), browsers, reportGenerator);
        testsExecutor.executeTests();
    }
}
