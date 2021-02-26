package ru.kireev.FSB_Database_SpringBoot.entities;


public enum Marriage {

    UNMARRIED("Не в браке"), MARRIED("В браке");

    private final String title;

    Marriage(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
