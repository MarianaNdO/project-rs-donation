package mariana.nascimento.projectrsdonation.dtos.instituition;

import mariana.nascimento.projectrsdonation.entities.Instituition;

import java.util.List;

public class InstituitionMapper {
    public static InstituitionListDto toDto (Instituition entity){
        if(entity == null) return null;

        InstituitionListDto instituitionDto = new InstituitionListDto();

        instituitionDto.setCnpj(entity.getCnpj());
        instituitionDto.setName(entity.getName());
        instituitionDto.setPassword(entity.getPassword());
        instituitionDto.setId(entity.getId());
        instituitionDto.setEmail(entity.getEmail());
        instituitionDto.setDonations(entity.getDonations());

        return instituitionDto;
    }

    public static List<InstituitionListDto> toDto (List<Instituition> entities){
        return entities.stream().map(InstituitionMapper::toDto).toList();
    }

    public static Instituition toEntity(InstituitionCreationDto dto){
        if (dto == null) return null;

        Instituition instituition = new Instituition();

        instituition.setEmail(dto.getEmail());
        instituition.setName(dto.getName());
        instituition.setPassword(dto.getPassword());
        instituition.setCnpj(dto.getCnpj());


        return instituition;
    }
}
