package ro.fasttrackit.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.vetclinic.model.entity.PetEntity;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    @Query("select p from pet p where p.id = :pet_id")
    Optional<PetEntity> findPetById(@Param("pet_id") Long petId);
}
