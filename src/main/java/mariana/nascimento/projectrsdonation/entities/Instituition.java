package mariana.nascimento.projectrsdonation.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Instituition extends User{
    private String cnpj;
    @OneToMany(mappedBy = "instituition")
    List<Donation> donations;
}
