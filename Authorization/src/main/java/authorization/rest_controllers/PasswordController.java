package authorization.rest_controllers;

import authorization.utils.PasswordUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @GetMapping("/getPassword")
    public String getRandomPassword() {
        String password = PasswordUtils.generateRandomString();
        return password;
    }

}
