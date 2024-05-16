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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstituitionService {
    private final InstituitionRepository repository;

    public List<Instituition> list(){ return repository.findAll();}

    public Instituition byId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Instituition create(Instituition newinstituition){
        return repository.save(newinstituition);
    }

    public void delete(Integer id){
        Optional<Instituition> instituition = repository.findById(id);
        if (instituition.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.delete(instituition.get());
    }

    public Instituition update(Integer id, Instituition instituition){
        Optional<Instituition> instituitionOpt = repository.findById(id);

        if (instituitionOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Instituition updatedInstituition = instituitionOpt.get();

       updatedInstituition.setCnpj(instituition.getCnpj());
       updatedInstituition.setEmail(instituition.getEmail());
       updatedInstituition.setName(instituition.getName());
       updatedInstituition.setPassword(instituition.getPassword());
       updatedInstituition.setDonations(instituition.getDonations());

        return updatedInstituition;
    }
}
