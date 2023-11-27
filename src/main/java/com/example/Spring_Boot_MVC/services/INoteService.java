package com.example.Spring_Boot_MVC.services;


import com.example.Spring_Boot_MVC.entities.Note;
import com.example.Spring_Boot_MVC.exceptions.NotesExceptions;

import java.util.List;

public interface INoteService {

    List<Note> listAll();

    Note add(Note note);

    void deleteById(Long id) throws NotesExceptions;

    void update(Note note) throws NotesExceptions;

    Note getById(Long id) throws NotesExceptions;
}
