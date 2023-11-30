package com.example.Spring_Boot_MVC.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "note")
public class Note {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;


}
