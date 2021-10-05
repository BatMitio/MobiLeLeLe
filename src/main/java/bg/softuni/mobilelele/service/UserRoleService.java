package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.entity.enumerated.Role;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAllRoles();

    UserRole findByRole(Role user);
}
