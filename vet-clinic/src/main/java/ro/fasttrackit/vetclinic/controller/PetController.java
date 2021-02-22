package ro.fasttrackit.vetclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.model.PetDto;
import ro.fasttrackit.vetclinic.service.PetService;

import java.util.List;

@RestController
public class PetController {
    private final PetService service;

    public PetController(PetService injectedServ) {
        this.service = injectedServ;
    }

    @GetMapping("/api/pet/{id}")
    public PetDto getPetById(@RequestParam(name= "id", required = false) Long petId) {
        return this.service.getPetById(petId);
    }

    @GetMapping("/api/pet")
    public List<PetDto> getAllPets() {
        return service.findAllPets();
    }


    @PostMapping("/api/pet")
    public ResponseEntity<PetDto> createNewPet(@RequestBody PetDto petDtoRequest) {
        return ResponseEntity.ok(service.createNewPet(petDtoRequest));
    }


    @PutMapping("/api/pet")
    public ResponseEntity<PetDto> updatePet(@RequestBody PetDto updateRequest) {
        if (updateRequest.getId() == null || updateRequest.getId() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updateRequest);
        }
        return ResponseEntity.ok(service.updatePet(updateRequest));
    }


    @DeleteMapping("/api/pet/{id}")
    public void deletePet(@PathVariable(name = "id") Long idToDelete) {
        this.service.deletePetById(idToDelete);
    }

}
