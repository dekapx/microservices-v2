package com.dekapx.apps.repository;

import com.dekapx.apps.entity.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @EntityGraph(value = "Person.addresses")
    Person findByFirstName(String firstName);
}
