package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.entity.enumerated.Role;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public boolean login(UserLoginServiceModel userData) {
        Optional<User> userOpt =
                userRepository.findByUsername(userData.getUsername());

        if (userOpt.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(userData.getRawPassword(), userOpt.get().getPassword());

            if (success){
                User loggedInUser = userOpt.get();
                currentUser
                        .setLoggedIn(true)
                        .setUserName(loggedInUser.getUsername())
                        .setFirstName(loggedInUser.getFirstName())
                        .setLastName(loggedInUser.getLastName());

                loggedInUser.getRoles()
                        .forEach(r -> currentUser.addRole(r.getName()));
            }
            return success;
        }
    }

    private void logout() {
        currentUser.clear();
    }

    @Override
    public boolean register(UserRegisterServiceModel userData) {
        Optional<User> optUser = userRepository.findByUsername(userData.getUsername());
        if (optUser.isEmpty()) {
            UserRole role = userRoleRepository.findByName(userData.getUserRole().getName());
            User newUser =
                    new User(
                            userData.getUsername(),
                            passwordEncoder.encode(userData.getRawPassword()),
                            userData.getFirstName(),
                            userData.getLastName(),
                            true,
                            "").addRole(role);
            userRepository.saveAndFlush(newUser);
            this.currentUser
                    .setLoggedIn(true)
                    .setUserName(newUser.getUsername())
                    .setFirstName(newUser.getFirstName())
                    .setLastName(newUser.getLastName())
                    .setRoles(newUser.getRoles().stream().map(UserRole::getName).collect(Collectors.toSet()));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void initialize() {
        initializeRoles();
        initializeUsers();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRole adminRole = userRoleRepository.findByName(Role.ADMIN);
            UserRole userRole = userRoleRepository.findByName(Role.USER);

            User admin = new User()
                    .setUsername("admin")
                    .setPassword(passwordEncoder.encode("test"))
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setActive(true);

            admin.setRoles(Set.of(adminRole, userRole));
            userRepository.save(admin);

            User pesho = new User()
                    .setUsername("pesho")
                    .setPassword(passwordEncoder.encode("test"))
                    .setFirstName("Pesho")
                    .setLastName("Petrov")
                    .setActive(true);

            pesho.setRoles(Set.of(userRole));
            userRepository.save(pesho);
        }
    }

    private void initializeRoles() {
        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setName(Role.ADMIN);

            UserRole userRole = new UserRole();
            userRole.setName(Role.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }
}
