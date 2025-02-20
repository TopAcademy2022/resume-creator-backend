package resume.creator.backend.top;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import resume.creator.logic.models.User;
import resume.creator.logic.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("/registration")
    public boolean AddRegistrationUser(@RequestParam String login,@RequestParam String password) {
        User newUser = new User();
        newUser.Login = login;
        newUser.Password = password;

        UserService userService = new UserService();
        
        return userService.CheckloginAndPassword(newUser);
    }
}