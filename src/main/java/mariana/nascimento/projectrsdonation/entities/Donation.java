package mariana.nascimento.projectrsdonation.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double goal;
    private double collected;
    @ManyToOne
    private Instituition instituition;
}
