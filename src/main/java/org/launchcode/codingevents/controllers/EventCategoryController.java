package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepo;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepo eventCategoryRepo;

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepo.findAll());
        return "eventCategories/index";
    }

    @GetMapping("create")
    public String renderCreateEventCategoryForm(Model model){
        model.addAttribute("title", "Create Category");
        model.addAttribute(new EventCategory());
        return "eventCategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(Model model, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Category");
            model.addAttribute(new EventCategory());
            return "eventCategories/create";
        }
        model.addAttribute("title", "Create Category");
        model.addAttribute(new EventCategory());
        return "redirect:";
    }
}
