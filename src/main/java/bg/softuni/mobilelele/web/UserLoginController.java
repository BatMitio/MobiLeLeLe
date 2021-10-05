package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final UserService userService;
    private final CurrentUser currentUser;

    public UserLoginController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel) {
        boolean loginSuccessful =
                userService.login(
                        new UserLoginServiceModel()
                                .setUsername(
                                        userLoginBindingModel.getUsername()
                                ).setRawPassword(
                                        userLoginBindingModel.getPassword()
                                )
                );

        if (loginSuccessful) {
            System.out.println(currentUser.getFirstName());
            return "redirect:/";
        }

        return "redirect:/users/login";
    }
}
