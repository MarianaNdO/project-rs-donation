package mariana.nascimento.projectrsdonation.dtos.instituition;

import lombok.Data;
import mariana.nascimento.projectrsdonation.entities.Donation;

import java.util.List;

@Data
public class InstituitionCreationDto {
    private String name;
    private String email;
    private String password;
    private String cnpj;
}
