package ci.atos.gestcantineada.services.mappers;

import ci.atos.gestcantineada.models.Plat;
import ci.atos.gestcantineada.services.dtos.responses.PlatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PlatMapper {
    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.name", target = "name"),
    })
    PlatDTO toDto(Plat entity);

    @Mappings({
            @Mapping(source = "dto.id", target = "id"),
            @Mapping(source = "dto.name", target = "name"),
    })
    Plat toEntity(PlatDTO dto);
}
