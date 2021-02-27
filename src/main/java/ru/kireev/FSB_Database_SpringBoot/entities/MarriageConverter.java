package ru.kireev.FSB_Database_SpringBoot.entities;

import javax.persistence.AttributeConverter;

public class MarriageConverter implements AttributeConverter<Marriage, String> {

    @Override
    public String convertToDatabaseColumn(Marriage marriage) {

        return marriage.getTitle();

    }

    @Override
    public Marriage convertToEntityAttribute(String s) {

        switch (s) {
            case "В браке":
                return Marriage.MARRIED;

            case "Не в браке":
                return Marriage.UNMARRIED;

            default:
                throw new IllegalArgumentException(s + " - такого параметра не существует");
        }
    }
}
