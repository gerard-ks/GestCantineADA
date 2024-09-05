package ci.atos.gestcantineada.services;


import ci.atos.gestcantineada.services.dtos.requests.RequestDTO;
import ci.atos.gestcantineada.services.dtos.responses.MenuDTO;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    MenuDTO createMenu(RequestDTO menuDTO);
    Optional<MenuDTO> getMenuById(Long id);
    MenuDTO updateMenu(RequestDTO menuDTO);
    List<MenuDTO> getAllMenus();
    void deleteMenu(Long id);
    List<MenuDTO> searchMenus(String query);
}
