package ci.atos.gestcantineada.services;

import ci.atos.gestcantineada.services.dtos.requests.RequestDTO;
import ci.atos.gestcantineada.services.dtos.responses.PlatDTO;

import java.util.List;

public interface PlatService {
    PlatDTO createPlat(RequestDTO platDTO);
    List<PlatDTO> getAllPlats();
    void deletePlat(Long id);
    List<PlatDTO> searchlPlats(String query);
}
