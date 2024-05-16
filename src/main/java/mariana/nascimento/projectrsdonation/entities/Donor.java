package mariana.nascimento.projectrsdonation.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Donor extends User{
    private double amountDonated;
}
