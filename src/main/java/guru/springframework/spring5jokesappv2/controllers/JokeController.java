package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by igors on 7/12/22
 */
@Controller
public class JokeController {

    private final JokeService jokeService;

    //@Autowired - spring will automatically do that, when there's only 1 constructor
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""}) //any of these strings in URL should cause this method execution
    public String showJoke(Model model){
        //appends string returned by jokesService.getJoke() to the property "joke"
        model.addAttribute("joke", jokeService.getJoke());

        //this tells the Thymeleaf to look for template file called "index" in "templates" directory inside resources
        return "index";
    }
}
