package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.enumerated.Role;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;

public interface UserService {
    boolean login(String username, String password);

    boolean register(UserRegisterServiceModel userData);

}
