package ci.atos.gestcantineada.controllers;

import ci.atos.gestcantineada.services.PlatService;
import ci.atos.gestcantineada.services.dtos.requests.RequestDTO;
import ci.atos.gestcantineada.services.dtos.responses.PlatDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plats")
public class PlatController {

    private final PlatService platService;

    public PlatController(PlatService platService) {
        this.platService = platService;
    }

    @GetMapping
    public String plat() {
        return "pages/plats";
    }

    @GetMapping("/form")
    public String formPlat(Model model) {
        model.addAttribute("request", new RequestDTO());
        return "pages/formsPlat";
    }

    @PostMapping("/savePlatForm")
    public String saveForm(@Valid RequestDTO requestDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("request", requestDTO);
            return "pages/formsPlat";
        }

        PlatDTO platDTO = platService.createPlat(requestDTO);

        if (platDTO != null) {
            return "redirect:/plats";
        }

        return "pages/formsPlat";
    }
}
