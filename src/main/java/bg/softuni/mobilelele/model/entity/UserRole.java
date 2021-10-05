package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.entity.enumerated.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role name;

    public UserRole() {
    }

    public UserRole(Role name) {
        this.name = name;
    }

    public Role getName() {
        return name;
    }

    public UserRole setName(Role name) {
        this.name = name;
        return this;
    }
}
