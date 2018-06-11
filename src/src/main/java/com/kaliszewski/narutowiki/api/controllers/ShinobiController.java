package com.kaliszewski.narutowiki.api.controllers;
import java.util.ArrayList;
import java.util.Optional;

import com.kaliszewski.narutowiki.api.models.Jutsu;
import com.kaliszewski.narutowiki.api.models.Shinobi;
import com.kaliszewski.narutowiki.api.repository.ShinobiRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(ShinobiController.main_url)
@AllArgsConstructor
public class ShinobiController {


    private ShinobiRepository shinobiRepository;
    public static final String main_url = "/api/characters";


    @GetMapping(path="/add",params={"name","surname","age","namejutsu"})
    public @ResponseBody String addNewShinobi (@RequestParam String name,
                                                 @RequestParam String surname,
                                                 @RequestParam int age,
                                                 @RequestParam String namejutsu
    ) {


        Shinobi c = new Shinobi();
        c.setName(name);
        c.setSurname(surname);
        c.setAge(age);
        ArrayList<Jutsu> j = new ArrayList<>();
        Jutsu ju = new Jutsu();
        ju.setShinobi(c);
        ju.setName(namejutsu);
        j.add(ju);
        c.setJutsu(j);
        shinobiRepository.save(c);

       
        return "Saved";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Shinobi> getAllShinobis() {

        return shinobiRepository.findAll();
    }

    @RequestMapping(value = "{shinobi_id}")
    public @ResponseBody Optional<Shinobi> getShinobi(@PathVariable Long shinobi_id) {

        return shinobiRepository.findById(shinobi_id);
    }
}
