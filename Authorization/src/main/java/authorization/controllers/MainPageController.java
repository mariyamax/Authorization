package authorization.controllers;


import authorization.models.User;
import authorization.services.UserService;
import authorization.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequiredArgsConstructor
@Controller
public class MainPageController {

    @Autowired
    private UserService userService;


    @GetMapping("/main")
    public String getStartPage(RedirectAttributes redirectAttributes,User user, Model model){
        User currentUser = userService.findByUsername(user.getUsername());
        if(currentUser==null||!user.getPassword().equals(SecurityUtils.decode(currentUser.getPassword()))) {
            redirectAttributes.addAttribute("user", new User());
            return "redirect:/login";
        }
        model.addAttribute("user", currentUser);
        return "mainPage";
    }


}


