package ru.csomod.notes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Note note = context.getBean("noteBean", Note.class);

        System.out.println(note.getHeader());
    }
}
