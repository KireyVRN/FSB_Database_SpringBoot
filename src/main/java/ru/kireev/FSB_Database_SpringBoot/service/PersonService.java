package ru.kireev.FSB_Database_SpringBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kireev.FSB_Database_SpringBoot.entities.Person;
import ru.kireev.FSB_Database_SpringBoot.repository.PersonRepository;
import java.util.List;


@Service
//@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Person getById(int id) {
        return personRepository.findById(id).get();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
