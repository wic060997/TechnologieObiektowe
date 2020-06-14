package pl.kozakowski.seleniumtestingautomat.model;

import pl.kozakowski.seleniumtestingautomat.Configuration;

public class ResultCrud {
    public Long[] timeAddElements;
    public Long[] timeEditElements;
    public Long[] timeRemoveElements;

    public ResultCrud() {
        timeAddElements = new Long[Configuration.AMOUNT_ADD_CRUD];
        timeEditElements = new Long[Configuration.AMOUNT_EDIT_CRUD];
        timeRemoveElements = new Long[Configuration.AMOUNT_ROMOVE_CRUD];
    }

    public ResultCrud(Long[] timeAddElements, Long[] timeEditElements, Long[] timeRemoveElements) {
        this.timeAddElements = timeAddElements;
        this.timeEditElements = timeEditElements;
        this.timeRemoveElements = timeRemoveElements;
    }


}
