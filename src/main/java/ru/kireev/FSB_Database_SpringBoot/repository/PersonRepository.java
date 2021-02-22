package ru.kireev.FSB_Database_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kireev.FSB_Database_SpringBoot.entities.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}