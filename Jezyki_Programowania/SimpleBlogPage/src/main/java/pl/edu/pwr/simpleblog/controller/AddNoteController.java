package pl.edu.pwr.simpleblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pwr.simpleblog.model.NoteDAO;

/**
 * Created by SQUIER on 2015-12-21.
 */
@Controller
@RequestMapping("/notes")
public class AddNoteController {

    @Autowired
    NoteDAO noteDAO;

    @RequestMapping("/addNote")
    public String addNote() {
        return "addNote";
    }

    @RequestMapping("/saveNote")
    public ModelAndView saveNote(@RequestParam("title") String title,
                                 @RequestParam("content") String content) {
        noteDAO.addNote(title, content);

        return new ModelAndView("addNote", "noteAdded", "Note added!");
    }

}
