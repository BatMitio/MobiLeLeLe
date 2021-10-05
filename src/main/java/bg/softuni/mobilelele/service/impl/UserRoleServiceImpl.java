package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.entity.enumerated.Role;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<UserRole> getAllRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole findByRole(Role user) {
        return userRoleRepository.findByName(user);
    }
}
