package ro.fasttrackit.vetclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.model.VetDto;
import ro.fasttrackit.vetclinic.service.VetService;

import java.util.List;

@RestController
public class VetController {
    private final VetService service;

    public VetController(VetService injectedService){
        this.service = injectedService;
    }

    @GetMapping("/api/vet/{id}")
    public VetDto getVetById(@RequestParam(name = "id", required = false) Long vetId){
        return this.service.getVetById(vetId);
    }

    @GetMapping("/api/vet")
    public List<VetDto> getAllVets(){return this.service.findAllVets();}

    @PostMapping("/api/vet")
    public ResponseEntity<VetDto> createNewVet(@RequestBody VetDto vetRequest){
        return ResponseEntity.ok(service.createNewVet(vetRequest));
    }

    @PutMapping("/api/vet")
    public ResponseEntity<VetDto> updateVet(@RequestBody VetDto updateRequest){
        if (updateRequest.getId() == null || updateRequest.getId() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updateRequest);
        }
        return ResponseEntity.ok(service.updateVet(updateRequest));
    }

    @DeleteMapping("/api/vet/{id}")
    public void deleteVet(@PathVariable(name = "id") Long idToDelete){
        this.service.deleteVetById(idToDelete);
    }
}
