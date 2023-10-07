package ru.csomod.notes.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.csomod.notes.dao.NoteDAO;
import ru.csomod.notes.models.Note;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteDAO noteDAO;
    @Autowired
    public NoteController(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    /**
     * Получение всех заметок
     * @param model модель
     * @return путь на html-представление
     */
    @GetMapping()
    public String index(Model model){
        model.addAttribute("notes", noteDAO.index());
        return "note/index";
    }

    /**
     * Получение одной заметки
     * @param id идентификатор заметки
     * @param model модель
     * @return путь на html-представление
     */
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", noteDAO.show(id));
        return "note/show";
    }

    @GetMapping("/new")
    public String newNote(@ModelAttribute("note") Note note){
        return "note/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("note") Note note){
        noteDAO.safe(note);
        return "redirect:/notes";
    }
}
