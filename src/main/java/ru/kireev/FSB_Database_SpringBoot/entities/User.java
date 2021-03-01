package ru.kireev.FSB_Database_SpringBoot.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Data
@Table(name = "users")
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    @NotBlank(message = "Введите логин")
    @Size(min = 4, message = "Логин должен быть не менее 4 символов")
    private String login;

    @Column(name = "password")
    @NotBlank(message = "Введите пароль")
    @Size(min = 4, message = "Пароль должен быть не менее 4 символов")
    private String password;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

}
