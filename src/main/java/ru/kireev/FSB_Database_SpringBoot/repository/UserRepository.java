package ru.kireev.FSB_Database_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kireev.FSB_Database_SpringBoot.entities.User;


@Repository
public interface UserRepository extends JpaRepository <User,Integer> {

    User findByLogin(String login);

}
