package ro.fasttrackit.vetclinic.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.fasttrackit.vetclinic.model.Pet;
import ro.fasttrackit.vetclinic.model.Species;
import ro.fasttrackit.vetclinic.model.entity.PetEntity;
import ro.fasttrackit.vetclinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {
    @InjectMocks
    private PetService service;
    @Mock
    private PetRepository repo;

    @Test
    public void createNewPet_test() {
        Pet petReq = new Pet();
        Mockito.when(this.repo.save(ArgumentMatchers.any(PetEntity.class))).thenReturn(new PetEntity());

        this.service.createNewPet(petReq);

        Mockito.verify(repo).save(ArgumentMatchers.any(PetEntity.class));
    }

    @Test
    public void findAllPets_test() { //passed
        Mockito.when(this.repo.findAll()).thenReturn(new ArrayList<PetEntity>());

        this.service.findAllPets();

        Mockito.verify(repo).findAll();
    }

    @Test
    public void updatePet_test() {
        PetEntity updatedEntityTest = new PetEntity();
        updatedEntityTest.setId(5L);
        updatedEntityTest.setName("Foxy");
        updatedEntityTest.setType(Species.DOG);
        Mockito.when(repo.save(ArgumentMatchers.any())).thenReturn(updatedEntityTest);

        Pet actualUpdate = service.updatePet(new Pet());

        Assertions.assertNotNull(actualUpdate);
        Assertions.assertEquals(5L, actualUpdate.getId());
        Assertions.assertEquals("Foxy", actualUpdate.getName());
        Assertions.assertEquals(Species.DOG, actualUpdate.getType());

    }

    @Test
    public void test_deleteById() {
        PetEntity petToDelet = new PetEntity();
        petToDelet.setId(9L);
        Mockito.doNothing().when(repo).deleteById(9L);

        this.service.deletePetById(9L);

        Mockito.verify(repo, Mockito.times(1)).deleteById(9L);
    }

    @Test
    public void getPetById_Test() {
        PetEntity getById = new PetEntity();
        getById.setId(7L);
        getById.setName("asd");
        getById.setType(Species.DOG);
        Mockito.when(repo.findPetById(ArgumentMatchers.any())).thenReturn(Optional.of(getById));

        Pet actualGetById = service.getPetById(7L);

        Assertions.assertNotNull(actualGetById);
        Assertions.assertEquals(7L, actualGetById.getId());
        Assertions.assertEquals("asd", actualGetById.getName());
        Assertions.assertEquals(Species.DOG, actualGetById.getType());
    }
}