package ro.fasttrackit.vetclinic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.model.DiagnosisDto;
import ro.fasttrackit.vetclinic.service.DiagnosisService;

@RestController
public class DiagnosisController {
    private final DiagnosisService service;

    public DiagnosisController(DiagnosisService injectedService){
        this.service = injectedService;
    }

    @PostMapping("/api/diagnosis")
    public ResponseEntity<DiagnosisDto> createNewDiagnosis(@RequestBody DiagnosisDto petDiagnosisDto){
        return ResponseEntity.ok(service.createNewDiagnosis(petDiagnosisDto));
    }


}
