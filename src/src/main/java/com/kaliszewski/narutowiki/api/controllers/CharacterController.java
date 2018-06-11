package com.kaliszewski.narutowiki.api.controllers;
import java.util.ArrayList;

import com.kaliszewski.narutowiki.api.models.Character;
import com.kaliszewski.narutowiki.api.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RestController
@RequestMapping(CharacterController.main_url)
public class CharacterController {
    @Autowired
    private CharacterRepository characterRepository;
    public static final String main_url = "/api/characters";
    @RequestMapping(value="{character_id}")
    public Character getCharacter(@PathVariable final int character_id){

        Character ch = new Character();
        ch.setName("Sasuke");
        ch.setSurname("Uchiha");
        ch.setAge(30);
        ArrayList<String> tmp_jutsu = new ArrayList()
        {
            {
                add("Sharingan");
                add("Chidori");
                add("Katon");
            }
        };
        ch.setJutsu(tmp_jutsu);




        return ch;
    }

    @GetMapping(path="/add",params={"name","surname","age","namejutsu"})
    public @ResponseBody String addNewCharacter (@RequestParam String name,
                                                 @RequestParam String surname,
                                                 @RequestParam int age,
                                                 @RequestParam String namejutsu
    ) {


        Character c = new Character();
        c.setName(name);
        c.setSurname(surname);
        c.setAge(age);
        ArrayList<String> j = new ArrayList<>();
       j.add(namejutsu);
        c.setJutsu(j);
        characterRepository.save(c);

       
        return "Saved";
    }
}
