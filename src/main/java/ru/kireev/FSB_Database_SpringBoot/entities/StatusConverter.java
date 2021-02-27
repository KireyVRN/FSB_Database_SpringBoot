package ru.kireev.FSB_Database_SpringBoot.entities;

import javax.persistence.AttributeConverter;

public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {

        return status.getTitle();

    }

    @Override
    public Status convertToEntityAttribute(String s) {

        switch (s) {
            case "Не опасен/опасна":
                return Status.NOT_DANGEROUS;

            case "Слегка опасен/опасна":
                return Status.SLIGHTLY_DANGEROUS;

            case "Опасен/Опасна":
                return Status.DANGEROUS;

            case "Особо опасен/опасна":
                return Status.EXTREMELY_DANGEROUS;

            default:
                throw new IllegalArgumentException(s + " - такого параметра не существует");
        }
    }
}
