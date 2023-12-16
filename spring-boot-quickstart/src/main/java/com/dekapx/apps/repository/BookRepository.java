package com.dekapx.apps.repository;

import com.dekapx.apps.entity.Book;
import com.dekapx.apps.entity.BookId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, BookId> {
    @Query("select b from Book b where b.id.isbn = ?1")
    Book findByIsbn(String isbn);
}
