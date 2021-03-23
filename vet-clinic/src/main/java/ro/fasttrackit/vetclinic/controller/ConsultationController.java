package ro.fasttrackit.vetclinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.model.ConsultationDto;
import ro.fasttrackit.vetclinic.model.OwnerDto;
import ro.fasttrackit.vetclinic.model.PetDto;
import ro.fasttrackit.vetclinic.service.ConsultationService;

import java.util.List;

@RestController
public class ConsultationController {

    private final ConsultationService service;

    public ConsultationController(ConsultationService injectedServ) {
        this.service = injectedServ;

    }

    @GetMapping("/api/consult/{id}")
    public ConsultationDto getConsultationById(@PathVariable(name = "id") Long consultId) {
        return this.service.getConsultationById(consultId);
    }

    @GetMapping("/api/consult")
    public List<ConsultationDto> getAllConsultations() {
        return service.findAllConsultations();
    }

    @PostMapping(value = "/api/consult")
    public ResponseEntity<ConsultationDto> createNewConsult(@RequestBody ConsultationDto consultationDtoRequest) {
        return ResponseEntity.ok(service.createNewConsultation(consultationDtoRequest));
    }

    @PutMapping("/api/consult")
    public ResponseEntity<ConsultationDto> updateConsultation(@RequestBody ConsultationDto updateRequest) {
        if (updateRequest.getId() == null || updateRequest.getId() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updateRequest);
        }
        return ResponseEntity.ok(service.updateConsultation(updateRequest));
    }

    @DeleteMapping("/api/consult/{id}")
    public void deleteConsultation(@PathVariable(name = "id") Long idToDelete) {
        this.service.deleteConsultationById(idToDelete);
    }


}
