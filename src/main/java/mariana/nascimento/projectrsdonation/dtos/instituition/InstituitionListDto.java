package mariana.nascimento.projectrsdonation.dtos.instituition;

import lombok.Data;
import mariana.nascimento.projectrsdonation.entities.Donation;

import java.util.List;

@Data
public class InstituitionListDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String cnpj;
    List<Donation> donations;
}
