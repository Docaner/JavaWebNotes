package ru.csomod.notes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/note")
public class NoteController {

    @GetMapping("/post")
    public String postNote(@RequestParam(required = false) String header,
                          @RequestParam(required = false) String content){
        //System.out.println("Header: " + header + "\nContent: " + content);
        return "note/post";
    }

    @GetMapping("/get")
    public String getNote(Model model){
        model.addAttribute("header", "Заголовок 1");
        model.addAttribute("content", "Контент 2");
        return "note/get";
    }

    @GetMapping("/list")
    public String getNotes() {
        return "note/post";
    }
}
