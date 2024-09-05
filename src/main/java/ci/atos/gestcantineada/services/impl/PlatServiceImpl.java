package ci.atos.gestcantineada.services.impl;

import ci.atos.gestcantineada.models.Menu;
import ci.atos.gestcantineada.models.Plat;
import ci.atos.gestcantineada.repositories.MenuRepository;
import ci.atos.gestcantineada.repositories.PlatRepository;
import ci.atos.gestcantineada.services.PlatService;
import ci.atos.gestcantineada.services.dtos.requests.RequestDTO;
import ci.atos.gestcantineada.services.dtos.responses.PlatDTO;
import ci.atos.gestcantineada.services.mappers.PlatMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatServiceImpl implements PlatService {

    private final PlatRepository platRepository;
    private final MenuRepository platMenuRepository;
    private final PlatMapper platMapper;

    public PlatServiceImpl(PlatRepository platRepository, MenuRepository platMenuRepository, PlatMapper platMapper) {
        this.platRepository = platRepository;
        this.platMenuRepository = platMenuRepository;
        this.platMapper = platMapper;
    }

    @Override
    public PlatDTO createPlat(RequestDTO platDTO) {

        Plat plat = new Plat();
        plat.setName(platDTO.getName());
        Plat savedPlat = platRepository.save(plat);

        Menu menu = new Menu();
        menu.setCreation_date(platDTO.getCreation_date());
        menu.setPlat(savedPlat);
        platMenuRepository.save(menu);

        return platMapper.toDto(savedPlat);
    }

    @Override
    public List<PlatDTO> getAllPlats() {
        return platRepository.findAll()
                .stream()
                .map(platMapper::toDto)
                .toList();
    }

    @Override
    public void deletePlat(Long id) {
        Optional<Plat> plat = platRepository.findById(id);
        if (plat.isPresent()) {
            platRepository.deleteById(id);
        }
    }

    @Override
    public List<PlatDTO> searchlPlats(String query) {
        return platRepository.findByName(query).stream()
                .map(platMapper::toDto)
                .toList();
    }
}
