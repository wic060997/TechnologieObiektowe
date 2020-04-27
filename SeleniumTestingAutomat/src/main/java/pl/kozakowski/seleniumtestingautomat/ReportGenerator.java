package pl.kozakowski.seleniumtestingautomat;

public class ReportGenerator {

    public void addStaticTableTestResult(Configuration.TECHNOLOGY technology, Configuration.BROWSER browser, Integer result) {
        if(result != null) {
            System.out.println("Dla strony "+ technology.label + " w przegladarce " + browser.label + " uzyskano wynik: " + result);
        } else {
            System.out.println("Wynik pusty");
        }
    }

}
