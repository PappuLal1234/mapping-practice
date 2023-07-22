package com.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Constructors, getters, setters
}
