package com.example.springboot.persistence;

import com.example.springboot.SpringBootTestApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = SpringBootTestApplication.class)
public class PersonPersistenceTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void cleanUp() {
        personRepository.deleteAll();
    }

    @Test
    void shouldUseSQLUpdateToChangeThePersonName() {
        Person person = new Person();
        person.setName("initialName");

        Person savedPerson = personRepository.save(person);
        person = personRepository.findById(person.getId()).get();
        assertEquals("initialName", savedPerson.getName());
        assertEquals(person.getId(), savedPerson.getId());

        person.setName("changedName");
        savedPerson = personRepository.save(person);
        person = personRepository.findById(person.getId()).get();
        assertEquals("changedName", savedPerson.getName());
        assertEquals(person.getId(), savedPerson.getId());

        assertEquals(1, personRepository.count());
    }


    @Test
    void shouldBeAbleToSavePersonWithBodyParts() {
        Person person = new Person();
        person.setName("initialName");
        person.getBodyParts().add(new Arm("left arm", person));
        person.getBodyParts().add(new Leg("left leg", person));
        Person savedPerson = personRepository.save(person);
        assertNotNull(savedPerson.getBodyParts());
        assertEquals(2, savedPerson.getBodyParts().size());
    }
}
