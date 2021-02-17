package ru.kireev.FSB_Database_SpringBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kireev.FSB_Database_SpringBoot.model.Person;
import ru.kireev.FSB_Database_SpringBoot.repository.PersonRepository;

import java.util.List;

@Service
@Transactional
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
        personRepository.saveAndFlush(person);
    }

    public void update(int id, Person person) {
        personRepository.update(
                person.getName(),
                person.getAge(),
                person.getCountryofresidence(),
                person.getMarriage(),
                person.getConviction(),
                person.getStatus(),
                person.getCommentary(),
                id);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
