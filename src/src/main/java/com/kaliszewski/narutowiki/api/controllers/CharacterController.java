package com.kaliszewski.narutowiki.api.controllers;
import java.util.ArrayList;

import com.kaliszewski.narutowiki.api.models.Jutsu;
import com.kaliszewski.narutowiki.api.models.Shinobi;
import com.kaliszewski.narutowiki.api.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RestController
@RequestMapping(CharacterController.main_url)
@AllArgsConstructor
public class CharacterController {


    private CharacterRepository characterRepository;
    public static final String main_url = "/api/characters";


    @GetMapping(path="/add",params={"name","surname","age","namejutsu"})
    public @ResponseBody String addNewCharacter (@RequestParam String name,
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
        characterRepository.save(c);

       
        return "Saved";
    }
}
