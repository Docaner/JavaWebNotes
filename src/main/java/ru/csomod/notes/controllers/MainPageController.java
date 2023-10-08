package ru.csomod.notes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.csomod.notes.dao.NoteDAO;

@Controller
@RequestMapping("/")
public class MainPageController {
    private final NoteDAO noteDAO;
    @Autowired
    public MainPageController(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("notes", noteDAO.index());
        return "index";
    }
}
