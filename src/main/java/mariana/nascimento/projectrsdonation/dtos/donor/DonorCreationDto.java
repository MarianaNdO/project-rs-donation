package mariana.nascimento.projectrsdonation.dtos.donor;

import lombok.Data;

@Data
public class DonorCreationDto {
    private String name;
    private String email;
    private String password;
    private double amountDonated;
}
