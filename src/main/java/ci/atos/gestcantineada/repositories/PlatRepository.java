package ci.atos.gestcantineada.repositories;

import ci.atos.gestcantineada.models.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatRepository extends JpaRepository<Plat, Long> {
    List<Plat> findByName(String name);
}
