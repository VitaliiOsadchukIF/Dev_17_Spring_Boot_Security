package com.example.Spring_Boot_MVC.exceptions;

public class NotesExceptions extends Exception {

    public NotesExceptions(Long id) {
    super("Note not found with id " + id);
    }
}