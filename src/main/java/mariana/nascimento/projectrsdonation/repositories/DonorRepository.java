package mariana.nascimento.projectrsdonation.repositories;

import mariana.nascimento.projectrsdonation.entities.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
}
