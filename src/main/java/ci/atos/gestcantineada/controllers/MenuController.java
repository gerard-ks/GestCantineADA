package ci.atos.gestcantineada.controllers;

import ci.atos.gestcantineada.services.MenuService;
import ci.atos.gestcantineada.services.dtos.requests.RequestDTO;
import ci.atos.gestcantineada.services.dtos.responses.MenuDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public String menu(Model model) {
        List<MenuDTO> menuDTOS = menuService.getAllMenus();
        model.addAttribute("allmenus", menuDTOS);
        return "pages/menus";
    }

    @GetMapping("/form")
    public String formMenu(Model model) {
        model.addAttribute("request", new RequestDTO());
        return "pages/formsMenu";
    }

    @GetMapping("/edit/{id}")
    public String updateFormMenu(@PathVariable Long id, Model model) {

        Optional<MenuDTO> menuDTO = menuService.getMenuById(id);

        if(menuDTO.isPresent()) {
            MenuDTO menuDTO1 = menuDTO.get();
            RequestDTO requestDTO = new RequestDTO();
            requestDTO.setId(menuDTO1.getId());
            requestDTO.setName(menuDTO1.getPlatDTO().getName());
            requestDTO.setCreation_date(menuDTO1.getCreation_date());
            model.addAttribute("request", requestDTO);
            return "pages/formsMenu";
        }

        return "pages/menus";
    }

    @PostMapping("/saveMenuForm")
    public String saveForm(@Valid RequestDTO requestDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("request", requestDTO);
            return "pages/formsMenu";
        }

        if(requestDTO.getId() != null) {
           MenuDTO update = menuService.updateMenu(requestDTO);
           if(update != null) {
               return "redirect:/menus";
           }
        }

        if(requestDTO.getId() == null) {
            MenuDTO menuDTO = menuService.createMenu(requestDTO);

            if (menuDTO != null) {
                return "redirect:/menus";
            }
        }

        return "pages/formsMenu";
    }
}
