package com.dekapx.apps.repository;

import com.dekapx.apps.entity.Person;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PersonRepositoryITest {
    private final PersonRepository repository;

    @Autowired
    public PersonRepositoryITest(final PersonRepository repository) {
        this.repository = repository;
    }

    @Test
    public void shouldReturnAllPersons() {
        List<Person> persons = new ArrayList<>();
        this.repository.findAll().forEach(persons::add);
        assertThat(persons)
                .isNotNull()
                .isNotEmpty()
                .hasAtLeastOneElementOfType(Person.class)
                .filteredOn(c -> !c.getFirstName().isEmpty());
    }

    @Test
    public void shouldFindPersonByEntityGraph() {
        Person person = this.repository.findByFirstName("Jack");
        assertThat(person)
                .isNotNull()
                .satisfies(p -> {
                    assertThat(p.getFirstName()).isEqualTo("Jack");
                });
    }
}
