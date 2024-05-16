package mariana.nascimento.projectrsdonation.services.instituition;

import lombok.RequiredArgsConstructor;
import mariana.nascimento.projectrsdonation.entities.Donation;
import mariana.nascimento.projectrsdonation.entities.Donor;
import mariana.nascimento.projectrsdonation.entities.Instituition;
import mariana.nascimento.projectrsdonation.repositories.DonationRepository;
import mariana.nascimento.projectrsdonation.repositories.InstituitionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstituitionService {
    private final InstituitionRepository repository;

    public List<Instituition> list(){ return repository.findAll();}

    public Instituition porId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Instituition create(Instituition newinstituition){
        return repository.save(newinstituition);
    }
}
