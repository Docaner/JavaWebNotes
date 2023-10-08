package ru.csomod.notes.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import ru.csomod.notes.models.Note;

import java.util.List;

@Controller
public class NoteDAO {

    private final JdbcTemplate jdbcTemplate;
    private String table;

    @Autowired
    public NoteDAO(JdbcTemplate jdbcTemplate, String table) {
        this.jdbcTemplate = jdbcTemplate;
        this.table = table;
    }

    @PostConstruct
    private void initializer(){
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS "+table+" (id SERIAL PRIMARY KEY, header VARCHAR, content VARCHAR)");
    }

    public List<Note> index() {
        return jdbcTemplate.query("SELECT * FROM " + table, new BeanPropertyRowMapper<>(Note.class));
    }

    public Note show(int id) {
        return jdbcTemplate.query("SELECT * FROM "+table+" WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Note.class))
                .stream().findAny().orElse(null);
    }

    public void safe(Note note){
        jdbcTemplate.update("INSERT INTO "+table+" (header, content) VALUES (?, ?)", note.getHeader(), note.getContent());
    }

    public void update(int id, Note note){
        jdbcTemplate.update("UPDATE "+table+" SET header = ?, content = ? WHERE id = ?", note.getHeader(), note.getContent(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM "+table+" WHERE id = ?", id);
    }
}
