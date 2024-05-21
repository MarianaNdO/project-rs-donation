package mariana.nascimento.projectrsdonation.dtos.donor;

import mariana.nascimento.projectrsdonation.entities.Donor;

import java.util.List;

public class DonorMapper {
    public static DonorListDto toDto (Donor entity){
        if(entity == null) return null;

        DonorListDto donorDto = new DonorListDto();

        donorDto.setId(entity.getId());
        donorDto.setEmail(entity.getEmail());
        donorDto.setName(entity.getName());
        donorDto.setPassword(entity.getPassword());
        donorDto.setAmountDonated(entity.getAmountDonated());

        return donorDto;
    }

    public static List<DonorListDto> toDto (List<Donor> entities){
        return entities.stream().map(DonorMapper::toDto).toList();
    }

    public static Donor toEntity(DonorCreationDto dto){
        if (dto == null) return null;

        Donor donor = new Donor();

        donor.setEmail(dto.getEmail());
        donor.setName(dto.getName());
        donor.setPassword(dto.getPassword());
        donor.setAmountDonated(dto.getAmountDonated());

        return donor;
    }
}
