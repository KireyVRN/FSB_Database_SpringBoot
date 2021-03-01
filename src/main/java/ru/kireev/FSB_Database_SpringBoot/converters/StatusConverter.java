package ru.kireev.FSB_Database_SpringBoot.converters;

import ru.kireev.FSB_Database_SpringBoot.entities.Status;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {

        return status.getTitle();

    }

    @Override
    public Status convertToEntityAttribute(String s) {

        return Arrays.stream(Status.values())
                .filter(x -> x.getTitle().equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(s + " - такого параметра не существует"));

    }
}
