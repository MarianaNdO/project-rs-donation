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
import java.util.Optional;

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

    public void delete(Integer id){
        Optional<Donor> donor = repository.findById(id);
        if (donor.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.delete(donor.get());
    }

    public Donor update(Integer id, Donor donor){
        Optional<Donor> donorOpt = repository.findById(id);

        if (donorOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Donor updatedDonor = donorOpt.get();

        updatedDonor.setEmail(donor.getEmail());
        updatedDonor.setName(donor.getName());
        updatedDonor.setPassword(donor.getPassword());
        updatedDonor.setAmountDonated(donor.getAmountDonated());

        return updatedDonor;
    }
}
