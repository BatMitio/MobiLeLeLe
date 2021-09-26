package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.enumerated.Role;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserRoleService;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean register(UserRegisterServiceModel userData) {
        Optional<User> optUser = userRepository.findByUsername(userData.getUsername());
        if(optUser.isEmpty()){
            Optional<UserRole> role = userRoleService.findByRole(Role.USER);
            User newUser =
                    new User(
                            userData.getUsername(),
                            passwordEncoder.encode(userData.getRawPassword()),
                            userData.getFirstName(),
                            userData.getLastName(),
                            true,
                            Set.of(role.get()),
                            "");
            userRepository.saveAndFlush(newUser);
            return true;
        } else {
            return false;
        }
    }
}
