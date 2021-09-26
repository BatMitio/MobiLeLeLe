package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.enumerated.Role;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<UserRole> findByRole(Role user) {
        return userRoleRepository.findByName(user);
    }
}
