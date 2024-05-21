package mariana.nascimento.projectrsdonation.controllers;

import lombok.RequiredArgsConstructor;
import mariana.nascimento.projectrsdonation.dtos.instituition.InstituitionCreationDto;
import mariana.nascimento.projectrsdonation.dtos.instituition.InstituitionListDto;
import mariana.nascimento.projectrsdonation.dtos.instituition.InstituitionMapper;
import mariana.nascimento.projectrsdonation.entities.Instituition;
import mariana.nascimento.projectrsdonation.services.instituition.InstituitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instituitions")
public class InstituitionController {

    private final InstituitionService instituitionService;

    @GetMapping
    public ResponseEntity<List<InstituitionListDto>> list(){
        List<Instituition> instituitions = instituitionService.list();
        if (instituitions.isEmpty()) return  ResponseEntity.noContent().build();
        return ResponseEntity.ok(InstituitionMapper.toDto(instituitions));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstituitionListDto> byId(@PathVariable Integer id){
        Instituition instituition = instituitionService.byId(id);
        return ResponseEntity.ok(InstituitionMapper.toDto(instituition));
    }

    @PostMapping
    public ResponseEntity<InstituitionListDto> create(@RequestBody InstituitionCreationDto instituitionDto){
        Instituition instituitionCreated = instituitionService.create(InstituitionMapper.toEntity(instituitionDto));
        InstituitionListDto dto = InstituitionMapper.toDto(instituitionCreated);

        URI uri = URI.create("/instituitions/" + dto.getId());
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        instituitionService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstituitionListDto> update(@PathVariable Integer id, @RequestBody Instituition instituition){
        Instituition uptInstituition = instituitionService.update(id, instituition);
        InstituitionListDto dto = InstituitionMapper.toDto(uptInstituition);
        return ResponseEntity.ok(dto);
    }
}
