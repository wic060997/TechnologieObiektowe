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

    public abstract Long performStaticDataTest();
    public abstract Long performStaticTableTest();
//    public abstract Long performDynamicDataTest();
    public abstract Long performDynamicTableTest(Configuration.AMOUNT_DATA amount_data);

    public Configuration.TECHNOLOGY getTechnology() {
        return technology;
    }

    public Long analyzeLog(String startText, String stopText) {
        Long startTime = 0L;
        Long stopTime = Long.MIN_VALUE;
        String temp;
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if(entry.getMessage().contains(startText)) {
                temp = entry.getMessage();
                temp = String.valueOf(temp.subSequence(temp.indexOf(startText) + startText.length(), temp.length()));
                temp = temp.replace("\"","");
                startTime = Long.parseLong(temp);
            }
            if(entry.getMessage().contains(stopText)) {
                temp = entry.getMessage();
                temp = String.valueOf(temp.subSequence(temp.indexOf(stopText) + stopText.length(), temp.length()));
                temp = temp.replace("\"","");
                stopTime = Long.parseLong(temp);
            }
        }
        System.out.println("Start: " + startTime + " Stop: " + stopTime + " Diff: " + (stopTime - startTime));
        return stopTime - startTime;
//        return Math.toIntExact(stopTime - startTime);
    }

}
