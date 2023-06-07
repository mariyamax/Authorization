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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
public class AccessPageController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getStartPage() {
        return "accessPage";
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("registration", "registration");
        return "accessPage";
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("login", "login");
        return "accessPage";
    }

    @PostMapping("/login")
    public String yourMethod(RedirectAttributes redirectAttributes, User user, Model model) {
        User currentUser = userService.findByUsername(user.getUsername());
        if (currentUser == null || !(user.getPassword().equals(SecurityUtils.decode(currentUser.getPassword())))) {
            redirectAttributes.addAttribute("user", new User());
            redirectAttributes.addAttribute("login", "login");
            redirectAttributes.addAttribute("error", "403");
            return "redirect:/login";
        }
        //addFlashAttribute - для того, чтоб user остался в сессии
        redirectAttributes.addFlashAttribute("user", currentUser);
        return "redirect:/main";
    }

    @PostMapping("/registration")
    public String registerNewUser(User user, Model model) {
        if (!(PasswordUtils.symbolVerify(user.getPassword()))) {
            model.addAttribute("user", new User());
            model.addAttribute("registration", "registration");
            model.addAttribute("error", "incorrect password");
            return "accessPage";
        }
        if (!userService.createUser(user)) {
            model.addAttribute("user", new User());
            model.addAttribute("registration", "registration");
            model.addAttribute("error", "name must be unique");
            return "accessPage";
        }

        model.addAttribute("user", new User());
        model.addAttribute("login", "login");

        return "accessPage";
    }

}
