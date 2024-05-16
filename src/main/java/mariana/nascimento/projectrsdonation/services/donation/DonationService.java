package mariana.nascimento.projectrsdonation.services.donation;

import lombok.RequiredArgsConstructor;
import mariana.nascimento.projectrsdonation.entities.Donation;
import mariana.nascimento.projectrsdonation.repositories.DonationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository repository;

    public List<Donation> list(){ return repository.findAll();}

    public Donation byId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Donation create(Donation newDonation){
       return repository.save(newDonation);
    }

    public void delete(Integer id){
        Optional<Donation> donation = repository.findById(id);
        if (donation.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.delete(donation.get());
    }

    public Donation update(Integer id, Donation donation){
        Optional<Donation> donationOpt = repository.findById(id);

        if (donationOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Donation updatedDonation = donationOpt.get();

        updatedDonation.setGoal(donation.getGoal());
        updatedDonation.setCollected(donation.getCollected());
        updatedDonation.setInstituition(donation.getInstituition());

        return updatedDonation;
    }
}
