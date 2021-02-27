package ru.kireev.FSB_Database_SpringBoot.entities;

import javax.persistence.AttributeConverter;

public class ConvictionConverter implements AttributeConverter<Conviction, String> {

    @Override
    public String convertToDatabaseColumn(Conviction conviction) {

        return conviction.getTitle();

    }

    @Override
    public Conviction convertToEntityAttribute(String s) {

        switch (s) {
            case "Имеет":
                return Conviction.YES;

            case "Не имеет":
                return Conviction.NOT;

            default:
                throw new IllegalArgumentException(s + " - такого параметра не существует");
        }
    }
}
