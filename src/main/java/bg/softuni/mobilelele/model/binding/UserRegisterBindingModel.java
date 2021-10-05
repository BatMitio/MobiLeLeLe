package bg.softuni.mobilelele.model.binding;

import bg.softuni.mobilelele.model.entity.UserRole;

public class UserRegisterBindingModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserRole userRole;


    public UserRegisterBindingModel() {
    }

    public UserRegisterBindingModel(String firstName, String lastName, String username, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public UserRegisterBindingModel setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }
}
