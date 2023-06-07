package com.booklibrary.booklibrary.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45, unique = true)
    private String name;
    private String author;

    @Column(nullable = true, length = 64)
    private String photos;


    private long size;

    private byte[] content;

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;

        return "/book-photos/" + id + "/" + photos;
    }

}
