package ru.kireev.FSB_Database_SpringBoot.entities;


public enum Marriage {

    UNMARRIED("Не женат/замужем"), MARRIED("Женат/Замужем");

    private final String title;

    Marriage(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
