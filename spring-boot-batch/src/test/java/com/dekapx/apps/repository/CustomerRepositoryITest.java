package com.dekapx.apps.repository;

import com.dekapx.apps.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryITest {
    private final CustomerRepository repository;

    @Autowired
    public CustomerRepositoryITest(final CustomerRepository repository) {
        this.repository = repository;
    }

    @Test
    public void shouldReturnAllContacts() {
        List<Customer> customers = new ArrayList<>();
        this.repository.findAll().forEach(customers::add);
        assertThat(customers)
                .isNotNull()
                .isNotEmpty()
                .hasAtLeastOneElementOfType(Customer.class)
                .filteredOn(c -> !c.getFirstName().isEmpty());
    }
}
