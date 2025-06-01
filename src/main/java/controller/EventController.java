package controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import repository.LocatieRepository;
import service.EventService;
import org.springframework.ui.Model;
import Model.Event;

@Controller
public class EventController {

    private final EventService eventService;
    private final LocatieRepository locatieRepository;
    public EventController(EventService eventService, LocatieRepository locatieRepository) {
        this.eventService = eventService;
        this.locatieRepository = locatieRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("events", eventService.getRecentEvents());
        return "index";
    }

    @GetMapping("/new")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locaties", locatieRepository.findAll());
        return "new";
    }

    @PostMapping("/new")
    public String saveEvent(@Valid @ModelAttribute Event event, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("locaties", locatieRepository.findAll());
            return "new";
        }
        eventService.saveEvent(event);
        return "redirect:/";
    }

    //@GetMapping("/event/{id}")
    //public String eventDetails(@PathVariable String id, Model model) {
      //  Event event = eventService.findById(String id).orElseThrow(() -> new IllegalArgumentException("Ongeldig ID"));
        //model.addAttribute("event", event);
        //return "details";
    //}


}
