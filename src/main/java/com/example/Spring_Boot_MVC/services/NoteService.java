package com.example.Spring_Boot_MVC.services;


import com.example.Spring_Boot_MVC.entities.Note;
import com.example.Spring_Boot_MVC.exceptions.NotesExceptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService implements INoteService {

    private final List<Note> noteList = new ArrayList<>();


    @Override
    public List<Note> listAll() {

        return noteList;
    }

    private long generateId() {

        if (noteList.isEmpty()) {
            return 0L;
        } else {
            return noteList.size() + 1;
        }
    }

    @Override
    public Note add(Note note) {
        Long id = generateId();
        note.setId(id);
        noteList.add(note);
        return note;
    }

    @Override
    public void deleteById(Long id) throws NotesExceptions {
        Note note = getById(id);

        if (note == null) {
            throw new NotesExceptions(id);
        } else {
            noteList.remove(note);
        }
    }

    @Override
    public Note getById(Long id) throws NotesExceptions {
        for (Note note : noteList) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new NotesExceptions(id);
    }

    @Override
    public void update(Note note) throws NotesExceptions {
        Note existingNote = getById(note.getId());

        if (existingNote == null) {
            throw new NotesExceptions(note.getId());
        } else {

            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
        }
    }


}
