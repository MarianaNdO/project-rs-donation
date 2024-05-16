package mariana.nascimento.projectrsdonation.repositories;

import mariana.nascimento.projectrsdonation.dtos.donation.DonationMapper;
import mariana.nascimento.projectrsdonation.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
}
