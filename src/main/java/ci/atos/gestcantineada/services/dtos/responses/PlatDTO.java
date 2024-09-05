package ci.atos.gestcantineada.services.dtos.responses;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatDTO {
    private Long id;
    @NotBlank
    private String name;
}
