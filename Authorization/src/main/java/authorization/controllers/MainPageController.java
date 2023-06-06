package authorization.controllers;


import authorization.models.User;
import authorization.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class MainPageController {

    @Autowired
    private UserService userService;


    @GetMapping("/main")
    public String getStartPage(User principal, Model model){
        User user = userService.findByUsername(principal.getUsername());
        model.addAttribute("user", user);
        return "mainPage";
    }


}


