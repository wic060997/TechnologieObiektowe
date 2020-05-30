package pl.kozakowski.seleniumtestingautomat;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ReportGenerator {

    private Map<Configuration.TECHNOLOGY, Map<Configuration.BROWSER, Map<Configuration.TEST_TYPE, ArrayList<Long>>>> report = new TreeMap<>();

    public void addTestResult(Configuration.TEST_TYPE testType, Configuration.TECHNOLOGY technology, Configuration.BROWSER browser, Long result) {
//        if (result == null && result == 0) {
        if (result == 0) {
            System.out.println("Wynik pusty " + System.nanoTime() + " czas!");
        } else {
            report.putIfAbsent(technology, new TreeMap<>());
            report.get(technology).putIfAbsent(browser, new TreeMap<>());
            report.get(technology).get(browser).putIfAbsent(testType, new ArrayList<>());
            report.get(technology).get(browser).get(testType).add(result);
        }
    }

//    public void addStaticTableTestResult(Configuration.TECHNOLOGY technology, Configuration.BROWSER browser, Configuration.TEST_TYPE testType, Integer result) {
//        if(result != null) {
//            report.putIfAbsent(technology, new TreeMap<>());
//            report.get(technology).putIfAbsent(browser, new TreeMap<>());
//            report.get(technology).get(browser).putIfAbsent(testType, new ArrayList<>());
//            report.get(technology).get(browser).get(testType).add(result);
//        } else {
////            System.out.println("Wynik pusty");
//        }
//    }
    
    public void printReport() {
        Integer amountOfTests = 0;
        Long sumOfResults = 0L;
        for (Configuration.TECHNOLOGY technology : report.keySet()) {
            for (Configuration.BROWSER browser : report.get(technology).keySet()) {
                for (Configuration.TEST_TYPE testType : report.get(technology).get(browser).keySet()) {
                    amountOfTests = 0;
                    sumOfResults = 0L;
                    for (Long result : report.get(technology).get(browser).get(testType)) {
                        amountOfTests++;
                        sumOfResults+=result;
                    }
                    System.out.println(technology.label + " | " + browser.label + " | " + testType.label + " -> próbek: " + amountOfTests + "; średni czas: " + sumOfResults/amountOfTests);
                }
            }
        }
    }

}
