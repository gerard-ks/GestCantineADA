package ci.atos.gestcantineada.services.impl;

import ci.atos.gestcantineada.models.Menu;
import ci.atos.gestcantineada.models.Plat;
import ci.atos.gestcantineada.repositories.MenuRepository;
import ci.atos.gestcantineada.repositories.PlatRepository;
import ci.atos.gestcantineada.services.MenuService;
import ci.atos.gestcantineada.services.dtos.requests.RequestDTO;
import ci.atos.gestcantineada.services.dtos.responses.MenuDTO;
import ci.atos.gestcantineada.services.mappers.MenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final PlatRepository platRepository;
    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuRepository menuRepository, PlatRepository platRepository, MenuMapper menuMapper) {
        this.menuRepository = menuRepository;
        this.platRepository = platRepository;
        this.menuMapper = menuMapper;
    }

    @Override
    public MenuDTO createMenu(RequestDTO menuDTO) {

        Plat plat = new Plat();
        plat.setName(menuDTO.getName());
        Plat savePlat = platRepository.save(plat);

        Menu menu = new Menu();
        menu.setCreation_date(menuDTO.getCreation_date());
        menu.setPlat(savePlat);

        Menu savedMenu = menuRepository.save(menu);
       return menuMapper.toDto(savedMenu);
    }

    @Override
    public Optional<MenuDTO> getMenuById(Long id) {
        return menuRepository.findById(id)
                .map(menuMapper::toDto);
    }

    @Override
    public MenuDTO updateMenu(RequestDTO menuDTO) {
       Menu menu = menuRepository.findById(menuDTO.getId()).orElseThrow(()-> new IllegalArgumentException("Invalid menu id: " + menuDTO.getId()));
       menu.setCreation_date(menuDTO.getCreation_date());
       Menu savedMenu = menuRepository.save(menu);
       return menuMapper.toDto(savedMenu);
    }

    @Override
    public List<MenuDTO> getAllMenus() {
        return menuRepository
                .findAll()
                .stream()
                .map(menuMapper::toDto)
                .toList();
    }

    @Override
    public void deleteMenu(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isPresent()) {
            menuRepository.deleteById(id);
        }
    }

    @Override
    public List<MenuDTO> searchMenus(String query) {
        return menuRepository.findByPlatName(query)
                .stream()
                .map(menuMapper::toDto)
                .toList();
    }
}
