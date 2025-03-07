package resume.creator.backend.top.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import resume.creator.logic.domain.models.User;
import resume.creator.logic.domain.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping("/registration")
    public boolean AddRegistrationUser(@RequestParam String login,@RequestParam String password) {
        User newUser = new User(login, password);

        UserService userService = new UserService();
        
        return userService.CheckloginAndPassword(newUser);
    }
}