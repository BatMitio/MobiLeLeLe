package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;

public interface UserService {
    boolean login(UserLoginServiceModel userData);

    boolean register(UserRegisterServiceModel userData);

    void initialize();
}
