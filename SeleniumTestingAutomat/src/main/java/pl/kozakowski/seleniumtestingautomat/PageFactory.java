package pl.kozakowski.seleniumtestingautomat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageFactory {

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected Configuration.TECHNOLOGY technology;

    public abstract Integer performStaticDataTest();
    public abstract Integer performStaticTableTest();
    public abstract Integer performDynamicDataTest();
    public abstract Integer performDynamicTableTest(Configuration.AMOUNT_DATA amount_data);

    public Configuration.TECHNOLOGY getTechnology() {
        return technology;
    }

    public Integer analyzeLog() {
        Long startTime = 0L;
        Long stopTime = 0L;
        String temp;
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if(entry.getMessage().contains("Start:")) {
                temp = entry.getMessage();
                temp = String.valueOf(temp.subSequence(temp.indexOf("Start:") + "Start:".length(), temp.length()));
                temp = temp.replace("\"","");
                startTime = Long.parseLong(temp);
            }
            if(entry.getMessage().contains("Stop:")) {
                temp = entry.getMessage();
                temp = String.valueOf(temp.subSequence(temp.indexOf("Stop:") + "Stop:".length(), temp.length()));
                temp = temp.replace("\"","");
                stopTime = Long.parseLong(temp);
            }
        }
        System.out.println("Start: " + startTime + " Stop: " + stopTime + " Diff: " + (stopTime - startTime));
        return Math.toIntExact(stopTime - startTime);
    }

}
