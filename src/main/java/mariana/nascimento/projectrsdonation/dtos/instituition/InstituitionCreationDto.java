package mariana.nascimento.projectrsdonation.dtos.instituition;

import lombok.Data;
@Data
public class InstituitionCreationDto {
    private String name;
    private String email;
    private String password;
    private String cnpj;
}
