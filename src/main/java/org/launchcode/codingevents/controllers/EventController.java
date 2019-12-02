package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    //private static HashMap<String, String> events = new HashMap<>();
    static ArrayList<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        Event newEvent = new Event(eventName, eventDescription);
        events.add(newEvent);
        return "redirect:";
    }

    @GetMapping("remove")
    public String displayRemoveEventForm(Model model) {
        model.addAttribute("events", events);
        model.addAttribute("title", "Remove Event");
        return "events/remove";
    }

    @PostMapping("remove")
    public String processRemoveEventForm(@RequestParam ArrayList<String> event) {

        for (String aEvent : event) {
            events.remove(aEvent);
        }

        return "redirect:";
    }

}
