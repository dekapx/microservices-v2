package com.dekapx.apps.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class BookId implements Serializable {
    @Column(name = "id")
    private String id;
    @Column(name = "isbn")
    private String isbn;
}
