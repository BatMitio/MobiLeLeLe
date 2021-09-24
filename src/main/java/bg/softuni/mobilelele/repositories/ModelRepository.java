package bg.softuni.mobilelele.repositories;

import bg.softuni.mobilelele.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
