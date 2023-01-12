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
    void shouldUseSQLUpdateToChangeThePersonName() { // this is the test that will fail with hibernate 6
        Person person = new Person();
        person.setName("initialName");

        Person savedPerson = personRepository.save(person);
        person = personRepository.findById(person.getId()).get();
        assertEquals("initialName", savedPerson.getName());
        assertEquals(person.getId(), savedPerson.getId()); // <-- the person that has been persisted is the same as the one being fetched

        person.setName("changedName");
        savedPerson = personRepository.save(person);

        person = personRepository.findById(person.getId()).get();
        assertEquals("changedName", savedPerson.getName());
        assertEquals(person.getId(), savedPerson.getId());  // <-- this line fails: the person that has been persisted is a new one.
        // the expected behaviour is that the existing person is updated

        assertEquals(1, personRepository.count());
    }


    @Test
    void shouldBeAbleToSavePersonWithBodyParts() { // can be ignored! this is just a test to make sure that this works
        Person person = new Person();
        person.setName("initialName");
        person.getLegs().add(new Leg("left leg", person));
        person.getLegs().add(new Leg("right leg", person));
        Person savedPerson = personRepository.save(person);

        person = personRepository.findByIdJoinFetchLegs(person.getId());
        assertEquals(person.getId(), savedPerson.getId());
        assertNotNull(person.getLegs());
        assertEquals(2, person.getLegs().size());
    }
}
