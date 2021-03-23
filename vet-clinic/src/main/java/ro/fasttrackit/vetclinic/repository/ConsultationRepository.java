package ro.fasttrackit.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.vetclinic.model.OwnerWithPetDto;
import ro.fasttrackit.vetclinic.model.entity.ConsultationEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {
    @Query("select c from consultation c where c.id = :consult_id")
    ConsultationEntity findConsultationById(@Param("consult_id") Long consultId);

@Query(value = "select * from consultation c where c.owner_id = :owner_id and c.pet_id = :pet_id", nativeQuery = true)
    Optional<ConsultationEntity> findOwnersWithPets(@Param("owner_id") Long ownerId, @Param("pet_id") Long petId);
}
