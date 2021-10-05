package bg.softuni.mobilelele.user;

import bg.softuni.mobilelele.model.entity.enumerated.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private boolean loggedIn;
    private String userName;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

    public CurrentUser() {
        this.loggedIn = false;
        this.userName = null;
        this.firstName = null;
        this.lastName = null;
        this.roles = new HashSet<>();
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public CurrentUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public CurrentUser setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    private CurrentUser clearRoles() {
        roles.clear();
        return this;
    }

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }

    public void clear(){
        setLoggedIn(false)
                .setLoggedIn(false)
                .setUserName(null)
                .setFirstName(null)
                .setLastName(null)
                .clearRoles();
    }

    public CurrentUser addRole(Role name) {
        this.roles.add(name);
        return this;
    }
}
