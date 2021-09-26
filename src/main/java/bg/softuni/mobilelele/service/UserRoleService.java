package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.enumerated.Role;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    List<UserRole> getAllRoles();

    Optional<UserRole> findByRole(Role user);
}
