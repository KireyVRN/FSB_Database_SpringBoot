package ru.kireev.FSB_Database_SpringBoot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kireev.FSB_Database_SpringBoot.entities.Person;
import ru.kireev.FSB_Database_SpringBoot.repositories.PersonRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAllPeople() {

        return personRepository.findAll();

    }

    public Person getById(int id) {

        return personRepository.findById(id).get();

    }

    public void saveOrUpdate(Person person) {

        personRepository.save(person);

    }

    public void deleteById(int id) {

        personRepository.deleteById(id);

    }
}
