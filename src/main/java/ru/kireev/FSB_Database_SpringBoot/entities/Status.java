package ru.kireev.FSB_Database_SpringBoot.entities;


public enum Status {

    NOT_DANGEROUS("Не опасен/опасна"),
    SLIGHTLY_DANGEROUS("Слегка опасен/опасна"),
    DANGEROUS("Опасен/Опасна"),
    EXTREMELY_DANGEROUS("Особо опасен/опасна");

    private final String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
