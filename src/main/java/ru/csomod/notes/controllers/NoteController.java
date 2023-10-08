package ru.csomod.notes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.csomod.notes.dao.NoteDAO;
import ru.csomod.notes.models.Note;

@Controller
@RequestMapping("/")
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
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("notes", noteDAO.index());
        return "index";
    }

    /**
     * Занесение новой заметки в БД
     * @param note объект заметки
     * @return ридирект на главную страницу
     */
    @PostMapping("/notes")
    public String create(@ModelAttribute("note") Note note){
        noteDAO.safe(note);
        return "redirect:/";
    }

    /**
     * Изменение заметки
     * @param note Объект заметки
     * @param id id заметки
     * @return ридирект на главную страницу с формой текущей заметки
     */
    @PatchMapping("notes/{id}")
    public String update(@ModelAttribute("note") Note note, @PathVariable("id") int id){
        noteDAO.update(id, note);
        return "redirect:/#" + id;
    }

    /**
     * Удаление заметки
     * @param id id заметки
     * @return ридирект на главную страницу
     */
    @GetMapping ("notes/{id}/delete")
    public String delete(@PathVariable("id") int id){
        noteDAO.delete(id);
        return "redirect:/";
    }
}
