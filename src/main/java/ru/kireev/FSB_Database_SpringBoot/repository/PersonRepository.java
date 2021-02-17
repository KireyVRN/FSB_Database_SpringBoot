package ru.kireev.FSB_Database_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kireev.FSB_Database_SpringBoot.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Modifying
    @Query("UPDATE Person p SET p.name = :name, p.age = :age, p.countryofresidence = :countryofresidence, p.marriage = :marriage, p.conviction = :conviction, p.status = :status, p.commentary = :commentary WHERE p.id = :id")
    void update(@Param("name") String name,
                @Param("age") int age,
                @Param("countryofresidence") String countryofresidence,
                @Param("marriage") String marriage,
                @Param("conviction") String conviction,
                @Param("status") String status,
                @Param("commentary") String commentary,
                @Param("id") int id);
}