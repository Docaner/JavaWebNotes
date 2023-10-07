package ru.csomod.notes.dao;

import org.springframework.stereotype.Controller;
import ru.csomod.notes.models.Note;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteDAO {
    private List<Note> notes = new ArrayList<Note>();
    private int NOTE_INDEX;

    {
        notes.add(new Note(++NOTE_INDEX,"Главное","Сегодня пасмурная погода: весь день дождь"));
        notes.add(new Note(++NOTE_INDEX,"Продукты","Яйца, курица, молоко, чай, вода"));
        notes.add(new Note(++NOTE_INDEX,"Завтра","Завести будильник на 6:30 и приготовить завтрак"));
    }

    public List<Note> index() {
        return notes;
    }

    public Note show(int id) {
        return notes.stream().filter(note -> note.getId() == id).findAny().orElse(null);
    }

    public void safe(Note note){
        note.setId(++NOTE_INDEX);
        notes.add(note);
    }

    public void update(int id, Note note){
        Note noteToUpdate = show(id);

        noteToUpdate.setHeader(note.getHeader());
        noteToUpdate.setContent(note.getContent());
    }

    public void delete(int id){
        notes.removeIf(note -> id == note.getId());
    }
}
