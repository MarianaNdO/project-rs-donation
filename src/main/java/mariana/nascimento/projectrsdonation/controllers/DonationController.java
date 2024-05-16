package mariana.nascimento.projectrsdonation.controllers;

import lombok.RequiredArgsConstructor;
import mariana.nascimento.projectrsdonation.dtos.donation.DonationCreationDto;
import mariana.nascimento.projectrsdonation.dtos.donation.DonationListDto;
import mariana.nascimento.projectrsdonation.dtos.donation.DonationMapper;
import mariana.nascimento.projectrsdonation.entities.Donation;
import mariana.nascimento.projectrsdonation.services.donation.DonationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/donations")
@RequiredArgsConstructor
public class DonationController {

    private final DonationService donationService;

    @GetMapping
    public ResponseEntity<List<DonationListDto>> list(){
        List<Donation> donations = donationService.list();
        if (donations.isEmpty()) return  ResponseEntity.noContent().build();
        return ResponseEntity.ok(DonationMapper.toDto(donations));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationListDto> byId(@PathVariable Integer id){
        Donation donation = donationService.byId(id);
        return ResponseEntity.ok(DonationMapper.toDto(donation));
    }

    @PostMapping
    public ResponseEntity<DonationListDto> create(@RequestBody DonationCreationDto donationDto){
        Donation donationCreated = donationService.create(DonationMapper.toEntity(donationDto));
        DonationListDto dto = DonationMapper.toDto(donationCreated);

        URI uri = URI.create("/donations/" + dto.getId());
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        donationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonationListDto> update(@PathVariable Integer id, @RequestBody Donation donation){
        Donation uptDonation = donationService.update(id, donation);
        DonationListDto dto = DonationMapper.toDto(uptDonation);
        return ResponseEntity.ok(dto);
    }
}
