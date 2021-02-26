package ru.kireev.FSB_Database_SpringBoot.entities;


public enum Conviction{

    NOT("Не имеет"), YES("Имеет");

    private final String title;

    Conviction(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
