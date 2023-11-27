package com.example.Spring_Boot_MVC.controller;

import com.example.Spring_Boot_MVC.entities.Note;
import com.example.Spring_Boot_MVC.exceptions.NotesExceptions;
import com.example.Spring_Boot_MVC.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
    private static final String REDIRECT = "redirect:/note/list";
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getAllNotes() {
        ModelAndView result = new ModelAndView("list");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping("/delete")
    public String deleteNoteById(@RequestParam("id") Long id) throws NotesExceptions {
        noteService.deleteById(id);
        return REDIRECT;
    }

    @GetMapping("/edit")
    public ModelAndView editNoteById(@RequestParam("id") Long id) throws NotesExceptions {
        ModelAndView result = new ModelAndView("edit");
        Note note = noteService.getById(id);
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/edit")
    public String saveEditNoteById(@ModelAttribute("note") Note note) throws NotesExceptions {
        noteService.update(note);
        return REDIRECT;
    }

    @GetMapping("/create")
    public ModelAndView createNote() {
        return new ModelAndView("create", "note", new Note());
    }

    @PostMapping("/create")
    public String saveCreateNote(@ModelAttribute("note") Note note) {
        noteService.add(note);
        return REDIRECT;
    }


}
