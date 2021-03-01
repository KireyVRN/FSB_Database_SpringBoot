package ru.kireev.FSB_Database_SpringBoot.converters;

import ru.kireev.FSB_Database_SpringBoot.entities.Conviction;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class ConvictionConverter implements AttributeConverter<Conviction, String> {

    @Override
    public String convertToDatabaseColumn(Conviction conviction) {

        return conviction.getTitle();

    }

    @Override
    public Conviction convertToEntityAttribute(String s) {

        return Arrays.stream(Conviction.values()).filter(x -> x.getTitle().equals(s)).findFirst().orElseThrow(() -> new IllegalArgumentException(s + " - такого параметра не существует"));


    }
}
