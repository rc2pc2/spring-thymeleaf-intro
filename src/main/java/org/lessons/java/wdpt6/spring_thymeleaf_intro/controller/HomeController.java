package org.lessons.java.wdpt6.spring_thymeleaf_intro.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.lessons.java.wdpt6.spring_thymeleaf_intro.model.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
    

    // @ Chiamata GET /
    // @ che ritorna semplicemente una view chiamata homepage.html
    // @ che si trova in resources/templates/
    @GetMapping
    public String home(){
        return "homepage";
    }

    // # Chiamata GET su /greetings + parametro in query string name ==> /greetings?name=.....
    //# Restituisce la view greetings in resources/templates, consegnandogli tre variabili: name, time, intero
    @GetMapping("/greetings")
    public String greetings(Model model, @RequestParam(name = "name") String name){
        model.addAttribute("name", name);
		model.addAttribute("time", LocalTime.now());
		model.addAttribute("intero", 333);

        return "greetings";
    }

    @GetMapping("/student/{id}")
    public String studentViewer( Model model, @PathVariable("id") Integer studentId){
        model.addAttribute("studentId", studentId); 
        model.addAttribute("student", "Studentessa Gina Ginetti");
        return "student";
    }

    
    // & esposizione di una esposizione in attesa di una chiamata GET nell'indirizzo /home
    // & con una risposta cruda in html diretto
    // * non usiamola, e' solo per capire
    @GetMapping("/home")
    @ResponseBody
    public String rawGreetings(){
        return "<html>"
            + "<body><h1>Ciao! <br> Ora esatta</h1>"
            + "<h2>Sono le " + LocalTime.now()+ "</h2>"
            + "</body>"
            + "</html>";
    }


    @GetMapping("/videogames")
    public String games(Model model){
        model.addAttribute("videogames", getAllGames());
        return "games/home";
    }

    private List<Game> getAllGames(){
        List<Game> videogamesList = new ArrayList<>();

        videogamesList.add(new Game("Battlefield 1", "FPS", LocalDate.now(), "8.4.22"));
        videogamesList.add(new Game("Call Of Duty 4: Modern Warfare", "FPS", LocalDate.now(), "55.4.22"));
        videogamesList.add(new Game("The Legend of Zelda", "Cult", LocalDate.now(), "3.4.22"));
        videogamesList.add(new Game("League of Legends", "MOBA", LocalDate.now(), "12.4.22"));
        videogamesList.add(new Game("DOTA", "MOBA", LocalDate.now(), "11.4.22"));

        return videogamesList;
    }

}


