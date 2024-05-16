package mariana.nascimento.projectrsdonation.dtos.donor;

import lombok.Data;

@Data
public class DonorListDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private double amountDonated;
}
