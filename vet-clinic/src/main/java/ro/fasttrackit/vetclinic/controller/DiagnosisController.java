package ro.fasttrackit.vetclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.model.ConsultationDto;
import ro.fasttrackit.vetclinic.model.DiagnosisDto;
import ro.fasttrackit.vetclinic.service.DiagnosisService;

import java.util.List;

@RestController
public class DiagnosisController {
    private final DiagnosisService service;

    public DiagnosisController(DiagnosisService injectedService) {
        this.service = injectedService;
    }

    @PostMapping("/api/diagnosis")
    public ResponseEntity<DiagnosisDto> createNewDiagnosis(@RequestBody DiagnosisDto petDiagnosisDto) {
        return ResponseEntity.ok(service.createNewDiagnosis(petDiagnosisDto));
    }

    @GetMapping("/api/diagnosis")
    public List<DiagnosisDto> getAllDiagnosi() {
        return service.findAllDiagnosis();
    }

    @GetMapping("/api/diagnosis/{id}")
    public DiagnosisDto getDiagnosisById(@PathVariable(name = "id") Long diagId) {
        return this.service.findDiagnosisById(diagId);
    }

    @PutMapping("/api/diagnosis")
    public ResponseEntity<DiagnosisDto> updateDiagnosis(@RequestBody DiagnosisDto updateRequest) {
        if (updateRequest.getId() == null || updateRequest.getId() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updateRequest);
        }
        return ResponseEntity.ok(service.updateDiagnosis(updateRequest));
    }

    @DeleteMapping("/api/diagnosis/{id}")
    public void deleteDiagnosis(@PathVariable(name = "id") Long idToDelete) {
        this.service.deletDiagnosis(idToDelete);
    }

}
