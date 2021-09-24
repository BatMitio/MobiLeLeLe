package bg.softuni.mobilelele.repositories;

import bg.softuni.mobilelele.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
