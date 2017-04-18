package ee.andmevara.controller;

import ee.andmevara.model.Comment;
import ee.andmevara.model.Entry;
import ee.andmevara.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Guestbook {

    @Autowired
    private EntryService entryService;

    private static final String HOME = "index";
    private static final String REDIRECT = "redirect:/guestbook";

    @GetMapping(value = "guestbook")
    public String mainPage(Model model) {
        model.addAttribute("guestbook", entryService.getAllEntries());
        return HOME;
    }

    @PostMapping(value = "/addEntry")
    public String addEntry(Entry guestbookEntry) {
        entryService.addEntry(guestbookEntry);
        return REDIRECT;
    }

    @PostMapping(value = "/addComment")
    public String addComment(Comment comment) {
        entryService.addComment(comment);
        return REDIRECT;
    }
}
