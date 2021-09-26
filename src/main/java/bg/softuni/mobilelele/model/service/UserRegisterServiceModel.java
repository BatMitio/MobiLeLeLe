package bg.softuni.mobilelele.model.service;

public class UserRegisterServiceModel {
    private String firstName;
    private String lastName;
    private String username;
    private String rawPassword;

    public UserRegisterServiceModel() {
    }

    public UserRegisterServiceModel(String firstName, String lastName, String username, String rawPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.rawPassword = rawPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public UserRegisterServiceModel setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
        return this;
    }
}
