package org.myproject.deckbuilder.controller;

import org.myproject.deckbuilder.model.Faction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    @Autowired
    CardController cardController;

/*    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("cards", cardController.findByFaction("Monster"));
        return "home";
    }*/
}
