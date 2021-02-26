package ru.kireev.FSB_Database_SpringBoot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kireev.FSB_Database_SpringBoot.entities.*;
import ru.kireev.FSB_Database_SpringBoot.service.PersonService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;


@Controller
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping()
    public String getAllPeople(Model model, Principal principal) {
        model.addAttribute("people", personService.getAllPeople());
        model.addAttribute("principal",principal);
        return "allPeople";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.getById(id));
        return "showPerson";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person, Model model) {
        model.addAttribute("marriage", Arrays.asList(Marriage.values()));
        model.addAttribute("status", Arrays.asList(Status.values()));
        model.addAttribute("conviction", Arrays.asList(Conviction.values()));
        return "newPerson";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, Model model) {

        model.addAttribute("marriage", Arrays.asList(Marriage.values()));
        model.addAttribute("status", Arrays.asList(Status.values()));
        model.addAttribute("conviction", Arrays.asList(Conviction.values()));

        if (bindingResult.hasErrors())
            return "newPerson";
        personService.saveOrUpdate(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personService.getById(id));
        model.addAttribute("marriage", Arrays.asList(Marriage.values()));
        model.addAttribute("status", Arrays.asList(Status.values()));
        model.addAttribute("conviction", Arrays.asList(Conviction.values()));
        return "editPerson";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id,
                         Model model) {

        model.addAttribute("marriage", Arrays.asList(Marriage.values()));
        model.addAttribute("status", Arrays.asList(Status.values()));
        model.addAttribute("conviction", Arrays.asList(Conviction.values()));

        if (bindingResult.hasErrors())
            return "editPerson";

        personService.saveOrUpdate(person);
        return "redirect:/people";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personService.delete(id);
        return "redirect:/people";
    }

}
