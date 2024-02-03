package com.dekapx.apps.repository;

import com.dekapx.apps.entity.Customer;
import com.dekapx.apps.model.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryITest {
    @Autowired
    private CustomerRepository repository;

    @BeforeEach
    public void setup() {
        Customer customer = Customer.builder()
                .firstName("Test")
                .lastName("User")
                .phone("+1 123 456 7890")
                .email("test.user@google.com")
                .status(Status.ACTIVE)
                .build();
        this.repository.save(customer);
    }

    @AfterEach
    public void teardown() {
        Customer customer = repository.findByFirstName("Test");
        this.repository.delete(customer);
    }

    @Autowired
    public CustomerRepositoryITest(final CustomerRepository repository) {
        this.repository = repository;
    }

    @Test
    public void shouldReturnCustomerWhenFindByFirstName() {
        Customer customer = this.repository.findByFirstName("Test");
        assertThat(customer)
                .isNotNull()
                .satisfies(c -> {
                    assertThat(c.getFirstName()).isEqualTo("Test");
                    assertThat(c.getStatus()).isEqualTo(Status.ACTIVE);
                });

    }

    @Test
    public void shouldReturnAllContacts() {
        List<Customer> customers = new ArrayList<>();
        this.repository.findAll().forEach(customers::add);
        assertThat(customers)
                .isNotNull()
                .isNotEmpty()
                .hasAtLeastOneElementOfType(Customer.class)
                .filteredOn(c -> c.getStatus().equals(Status.ACTIVE))
                .extracting(Customer::getFirstName).contains("Test");
    }
}
