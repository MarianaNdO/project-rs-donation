package mariana.nascimento.projectrsdonation.controllers;

import lombok.RequiredArgsConstructor;
import mariana.nascimento.projectrsdonation.dtos.donor.DonorCreationDto;
import mariana.nascimento.projectrsdonation.dtos.donor.DonorListDto;
import mariana.nascimento.projectrsdonation.dtos.donor.DonorMapper;
import mariana.nascimento.projectrsdonation.entities.Donor;
import mariana.nascimento.projectrsdonation.services.donor.DonorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @GetMapping
    public ResponseEntity<List<DonorListDto>> list(){
        List<Donor> donors = donorService.list();
        if (donors.isEmpty()) return  ResponseEntity.noContent().build();
        return ResponseEntity.ok(DonorMapper.toDto(donors));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonorListDto> byId(@PathVariable Integer id){
        Donor donor = donorService.byId(id);
        return ResponseEntity.ok(DonorMapper.toDto(donor));
    }

    @PostMapping
    public ResponseEntity<DonorListDto> create(@RequestBody DonorCreationDto donorDto){
        Donor donorCreated = donorService.create(DonorMapper.toEntity(donorDto));
        DonorListDto dto = DonorMapper.toDto(donorCreated);

        URI uri = URI.create("/donors/" + dto.getId());
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        donorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonorListDto> update(@PathVariable Integer id, @RequestBody Donor donor){
        Donor uptDonor = donorService.update(id, donor);
        DonorListDto dto = DonorMapper.toDto(uptDonor);
        return ResponseEntity.ok(dto);
    }
}
