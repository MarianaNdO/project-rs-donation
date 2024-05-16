package mariana.nascimento.projectrsdonation.dtos.donation;

import lombok.Data;
import mariana.nascimento.projectrsdonation.entities.Instituition;

@Data
public class DonationListDto {
    private Integer id;
    private Instituition instituition;
    private double goal;
    private double collected;
}
