package ru.kireev.FSB_Database_SpringBoot.entities;

import lombok.Data;
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

    @NotEmpty(message = "Укажите семейное положение")
    @Column(name = "marriage")
    private String marriage;

    @NotEmpty(message = "Укажите судимость")
    @Column(name = "conviction")
    private String conviction;

    @NotEmpty(message = "Укажите статус")
    @Column(name = "status")
    private String status;

    @Column(name = "commentary")
    private String commentary;

}
