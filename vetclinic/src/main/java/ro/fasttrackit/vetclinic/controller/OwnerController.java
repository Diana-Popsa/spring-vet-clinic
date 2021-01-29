package ro.fasttrackit.vetclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.vetclinic.model.Owner;
import ro.fasttrackit.vetclinic.service.OwnerService;

import java.util.List;

@RestController
public class OwnerController {
    private final OwnerService service;

    public OwnerController(OwnerService injectedOwnerServ) {
        this.service = injectedOwnerServ;
    }

    @PostMapping("/api/owner")
    public ResponseEntity<Owner> createNewOwner(@RequestBody Owner ownerRequested) {
        return ResponseEntity.ok(service.createNewOwner(ownerRequested));
    }


    @GetMapping("/api/owner")
    public List<Owner> getAllOwners() {
        return service.findAllOwners();
    }


    @GetMapping("/api/owner/{id}")
    public Owner getOwnerById(@PathVariable(name = "id") Long ownerId) {
        return service.getOwnerById(ownerId);
    }

    @PutMapping("/api/owner")
    public ResponseEntity<Owner> updateOwner(@RequestBody Owner updateRequest) {
        if (updateRequest.getId() == null || updateRequest.getId() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updateRequest);
        }
        return ResponseEntity.ok(service.updateOwner(updateRequest));
    }

    @DeleteMapping("/api/owner/{id}")
    public void deleteOwner(@PathVariable("id") Long idToBeDeleted) {
        this.service.deleteOwnerById(idToBeDeleted);
    }
}
