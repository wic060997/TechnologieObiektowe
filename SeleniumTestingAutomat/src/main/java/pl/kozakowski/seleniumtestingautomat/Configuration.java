package pl.kozakowski.seleniumtestingautomat;

public final class Configuration {

    public enum TECHNOLOGY {
        REACT("ReactJS"),
        ANGULAR("ANgularJS"),
        VUE("VueJS");

        public final String label;

        TECHNOLOGY(String label) {
            this.label = label;
        }
    }

    public enum BROWSER {
        CHROME("Google Chrome","chromedriver", "org.openqa.selenium.chrome.ChromeDriver"),
        FIREFOX("Mozilla Firefox", "firefoxdriver", "org.openqa.selenium.firefox.FirefoxDriver"),
        IE("Internt Explorer", "iedriver", "org.openqa.selenium.ie.InternetExplorerDriver"),
        OPERA("Opera", "operadriver", "org.openqa.selenium.opera.OperaDriver"),
        EDGE("Edge", "edgedriver", "org.openqa.selenium.edge.EdgeDriver");

        public final String label;
        public final String webDriverManagerMethod;
        public final String webDriverClass;

        BROWSER(String label, String webDriverManagerMethod, String webDriverClass) {
            this.label = label;
            this.webDriverManagerMethod = webDriverManagerMethod;
            this.webDriverClass = webDriverClass;
        }
    }

    public enum AMOUNT_DATA {
        _1DATA("1 data"),
        _1kDATA("1k data"),
        _10kDATA("10k data"),
        _1MDATA("1M data");

        public final String label;

        AMOUNT_DATA(String label) {
            this.label = label;
        }
    }

    public static final int AMOUNT_OF_TESTS = 5;
}