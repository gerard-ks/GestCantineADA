package ci.atos.gestcantineada.repositories;

import ci.atos.gestcantineada.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByPlatName(String title);
}
