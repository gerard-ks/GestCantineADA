package ci.atos.gestcantineada.services.dtos.responses;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MenuDTO {
    private Long id;
    @NotNull
    private Date creation_date;
    @NotNull
    private PlatDTO platDTO;
}
