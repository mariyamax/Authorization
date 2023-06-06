package authorization.controllers;

import authorization.models.User;
import authorization.services.UserService;
import authorization.utils.PasswordUtils;
import authorization.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class AccessPageController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordUtils passwordUtils;

    @GetMapping("/")
    public String getStartPage(){
        return "accessPage";
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("registration","registration");
        return "accessPage";
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("login","login");
        return "accessPage";
    }

    @PostMapping("/registration")
    public String registerNewUser(User user, Model model){
        if((passwordUtils.symbolVerify(user.getPassword(),user.getUsername()))) {
            if (!userService.createUser(user)) {
                model.addAttribute("user", new User());
                model.addAttribute("registration","registration");
                model.addAttribute("error","can not create user with such");
            } else {
                model.addAttribute("login","login");
            }
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("registration","registration");
            model.addAttribute("error","can not create user with such");
        }

        return "accessPage";
    }

}
