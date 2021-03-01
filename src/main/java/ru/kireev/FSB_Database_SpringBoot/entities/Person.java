package ru.kireev.FSB_Database_SpringBoot.entities;

import lombok.Data;
import ru.kireev.FSB_Database_SpringBoot.converters.ConvictionConverter;
import ru.kireev.FSB_Database_SpringBoot.converters.MarriageConverter;
import ru.kireev.FSB_Database_SpringBoot.converters.StatusConverter;

import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@Entity
@Table(name = "fsb_database")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Укажите имя")
    @Column(name = "name")
    private String name;

    @Digits(integer = 3, fraction = 0, message = "Возраст не корректен")
    @Positive(message = "Возраст не корректен")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Укажите страну проживания")
    @Column(name = "countryofresidence")
    private String countryofresidence;

    @Column(name = "marriage")
    @Convert(converter = MarriageConverter.class)
    private Marriage marriage;

    @Column(name = "conviction")
    @Convert(converter = ConvictionConverter.class)
    private Conviction conviction;

    @Column(name = "status")
    @Convert(converter = StatusConverter.class)
    private Status status;

    @Column(name = "commentary")
    private String commentary;

}
