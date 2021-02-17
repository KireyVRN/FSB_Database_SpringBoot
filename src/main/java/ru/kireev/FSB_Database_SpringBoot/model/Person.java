package ru.kireev.FSB_Database_SpringBoot.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

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

    @Min(value = 0, message = "Укажите возраст")
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
