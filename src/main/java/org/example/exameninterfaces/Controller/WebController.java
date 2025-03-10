package org.example.exameninterfaces.Controller;


import org.example.exameninterfaces.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    ItemRepository itemRepository;


    @GetMapping("/items/")
    public String allItems(Model model){
        var items = itemRepository.findAll();
        model.addAttribute("titulo", "Listado de Items");
        model.addAttribute("items", items);
        return "indexAllitems";
    }



}
