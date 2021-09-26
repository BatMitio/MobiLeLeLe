package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.service.UserRoleService;
import bg.softuni.mobilelele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserRegisterController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

    private final UserService userService;
    private final UserRoleService userRoleService;

    public UserRegisterController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @GetMapping("/users/register")
    public String getRegister(Model model) {
        model.addAttribute("registerForm", new UserRegisterBindingModel());
        model.addAttribute("optionsList", userRoleService.getAllRoles());
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(@ModelAttribute("registerForm") UserRegisterBindingModel userData) {

        boolean registerSuccessful = userService.register(
                new UserRegisterServiceModel()
                        .setUsername(userData.getUsername())
                        .setFirstName(userData.getFirstName())
                        .setLastName(userData.getLastName())
                        .setRawPassword(userData.getPassword())
        );

        LOGGER.info("{} ({} {}) tried to register with {}. Success = {}",
                userData.getUsername(),
                userData.getFirstName(),
                userData.getLastName(),
                userData.getPassword(),
                registerSuccessful);

        return "redirect:/users/register";
    }
}
