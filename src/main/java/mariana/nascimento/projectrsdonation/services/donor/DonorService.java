package mariana.nascimento.projectrsdonation.services.donor;

import lombok.RequiredArgsConstructor;
import mariana.nascimento.projectrsdonation.entities.Donation;
import mariana.nascimento.projectrsdonation.entities.Donor;
import mariana.nascimento.projectrsdonation.repositories.DonationRepository;
import mariana.nascimento.projectrsdonation.repositories.DonorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonorService {
    private final DonorRepository repository;

    public List<Donor> list(){ return repository.findAll();}

    public Donor byId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Donor create(Donor newDonor){
        return repository.save(newDonor);
    }
}
