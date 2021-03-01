package ru.kireev.FSB_Database_SpringBoot.converters;

import ru.kireev.FSB_Database_SpringBoot.entities.Conviction;
import ru.kireev.FSB_Database_SpringBoot.entities.Marriage;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class MarriageConverter implements AttributeConverter<Marriage, String> {

    @Override
    public String convertToDatabaseColumn(Marriage marriage) {

        return marriage.getTitle();

    }

    @Override
    public Marriage convertToEntityAttribute(String s) {

        return Arrays.stream(Marriage.values()).filter(x -> x.getTitle().equals(s)).findFirst().orElseThrow(() -> new IllegalArgumentException(s + " - такого параметра не существует"));

    }
}
