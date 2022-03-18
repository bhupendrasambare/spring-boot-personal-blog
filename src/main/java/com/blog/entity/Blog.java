package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Integer id;

    @NotNull
    @Column(name = "name")
    String name;
    String image;
    String date;
    int views;

    @Lob
    @Column(name = "about")
    private String about;

    @Lob
    @Column(name = "tags")
    private String tags;
}