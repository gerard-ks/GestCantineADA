package ci.atos.gestcantineada.services.mappers;

import ci.atos.gestcantineada.models.Menu;
import ci.atos.gestcantineada.services.dtos.responses.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.creation_date", target = "creation_date"),
            @Mapping(source = "entity.plat", target = "platDTO")
    })
    MenuDTO toDto(Menu entity);

    @Mappings({
            @Mapping(source = "dto.id", target = "id"),
            @Mapping(source = "dto.creation_date", target = "creation_date"),
            @Mapping(source = "dto.platDTO", target = "plat")
    })
    Menu toEntity(MenuDTO dto);
}
