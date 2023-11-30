package com.example.Spring_Boot_MVC.services;


import com.example.Spring_Boot_MVC.entities.Note;
import com.example.Spring_Boot_MVC.exceptions.NotesExceptions;
import com.example.Spring_Boot_MVC.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService implements INoteService {

    private final NoteRepository repository;

    @Override
    public List<Note> listAll() {
        return repository.findAll();
    }

    @Override
    public Note add(Note note) {
        return repository.save(note);
    }

    @Override
    public void deleteById(Long id) throws NotesExceptions {
        repository.deleteById(id);
    }

    @Override
    public Note getById(Long id) throws NotesExceptions {

        return repository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public void update(Note note) throws NotesExceptions {
       if (repository.existsById(note.getId())) {
           repository.save(note);
       }else {
           throw new NotesExceptions(note.getId());
       }

    }


}
