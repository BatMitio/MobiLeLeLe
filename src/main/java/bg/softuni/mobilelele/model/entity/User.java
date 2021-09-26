package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = true)
    private String password;
    @Column(nullable = true)
    private String firstName;
    @Column(nullable = true)
    private String lastName;
    @Column(nullable = true)
    private boolean isActive;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UserRole> roles = new HashSet<>();
    @Column(nullable = true)
    private String imageUrl;


    public User() {
    }

    public User(String username, String password, String firstName, String lastName, boolean isActive, Set<UserRole> roles, String imageUrl) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.roles = roles;
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public User setActive(boolean active) {
        isActive = active;
        return this;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public User setRoles(Set<UserRole> roles) {
        this.roles = roles;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public User setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
