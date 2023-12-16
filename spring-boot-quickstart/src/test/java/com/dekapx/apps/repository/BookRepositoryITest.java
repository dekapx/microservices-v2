package com.dekapx.apps.repository;

import com.dekapx.apps.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryITest {
    private final BookRepository repository;

    @Autowired
    public BookRepositoryITest(final BookRepository repository) {
        this.repository = repository;
    }

    @Test
    public void shouldReturnAllBooks() {
        List<Book> books = new ArrayList<>();
        this.repository.findAll().forEach(books::add);
        assertThat(books)
                .isNotNull()
                .isNotEmpty()
                .hasAtLeastOneElementOfType(Book.class)
                .filteredOn(c -> !c.getAuthor().isEmpty());
    }

    @Test
    public void shouldFindBookByIsbn() {
        String isbn = "1234-ABC-456";
        Book book = this.repository.findByIsbn(isbn);
        assertThat(book)
                .isNotNull()
                .satisfies(o ->
                        assertThat(o.getId().getIsbn()).isEqualTo(isbn));
    }
}
