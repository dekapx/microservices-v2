package com.dekapx.apps.repository;

import com.dekapx.apps.entity.Book;
import com.dekapx.apps.entity.BookId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, BookId> {
    @Query("select b from Book b where b.id.isbn = ?1")
    Book findByIsbn(String isbn);

    /**
     * Alternative to query for EmbeddedId query
     */
    Book findByIdIsbn(String isbn);

    @Query("select b from Book b where b.author = ?1")
    List<Book> findByAuthor(String author);
}
