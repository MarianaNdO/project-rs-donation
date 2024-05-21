package mariana.nascimento.projectrsdonation.repositories;

import mariana.nascimento.projectrsdonation.entities.Instituition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituitionRepository extends JpaRepository<Instituition, Integer> {
}
