package bg.softuni.mobilelele.repository;

import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.enumerated.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByName(Role name);
}
