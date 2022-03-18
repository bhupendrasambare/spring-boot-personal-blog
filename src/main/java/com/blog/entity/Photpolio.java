package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "photpolio")
@Data
public class Photpolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    String name;

    @Column(length = 500)
    String tags;

    @Lob
    @Column(name = "details")
    private String details;

    @Column(name = "image")
    private String image;

    int views;
}