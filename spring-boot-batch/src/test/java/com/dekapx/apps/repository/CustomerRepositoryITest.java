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

import static com.dekapx.apps.repository.CustomerTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryITest {
    private CustomerRepository repository;

    @Autowired
    public CustomerRepositoryITest(CustomerRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    public void setup() {
        Customer customer = createCustomer();
        this.repository.save(customer);
    }

    @AfterEach
    public void cleanUp() {
        Customer customer = repository.findByFirstNameAndLastName(FIRST_NAME, LAST_NAME);
        this.repository.delete(customer);
    }

    @Test
    public void shouldReturnCustomerWhenFindByFirstName() {
        Customer customer = this.repository.findByFirstNameAndLastName(FIRST_NAME, LAST_NAME);
        assertThat(customer)
                .isNotNull()
                .satisfies(c -> {
                    assertThat(c.getFirstName()).isEqualTo(FIRST_NAME);
                    assertThat(c.getLastName()).isEqualTo(LAST_NAME);
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
