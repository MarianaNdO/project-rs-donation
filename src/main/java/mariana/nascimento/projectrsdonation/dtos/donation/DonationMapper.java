package mariana.nascimento.projectrsdonation.dtos.donation;
import mariana.nascimento.projectrsdonation.entities.Donation;
import java.util.List;

public class DonationMapper {

    public static DonationListDto toDto (Donation entity){
        if(entity == null) return null;

        DonationListDto donationDto = new DonationListDto();

        donationDto.setId(entity.getId());
        donationDto.setGoal(entity.getGoal());
        donationDto.setCollected(entity.getCollected());
        donationDto.setInstituition(entity.getInstituition());

        return donationDto;
    }

    public static List<DonationListDto> toDto (List<Donation> entities){
        return entities.stream().map(DonationMapper::toDto).toList();
    }

    public static Donation toEntity(DonationCreationDto dto){
        if (dto == null) return null;

        Donation donation = new Donation();

        donation.setCollected(dto.getCollected());
        donation.setGoal(dto.getGoal());
        donation.setInstituition(dto.getInstituition());

        return donation;
    }
}
