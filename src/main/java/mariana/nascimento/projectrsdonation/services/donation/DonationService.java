package mariana.nascimento.projectrsdonation.services.donation;

import lombok.RequiredArgsConstructor;
import mariana.nascimento.projectrsdonation.entities.Donation;
import mariana.nascimento.projectrsdonation.repositories.DonationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository repository;

    public List<Donation> list(){ return repository.findAll();}

    public Donation porId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Donation create(Donation newDonation){
       return repository.save(newDonation);
    }
}
