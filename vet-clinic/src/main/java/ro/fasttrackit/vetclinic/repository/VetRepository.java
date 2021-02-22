package ro.fasttrackit.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.vetclinic.model.entity.VetEntity;

@Repository
public interface VetRepository extends JpaRepository<VetEntity, Long> {
    @Query("select v from vet v where v.id = :vet_id")
    VetEntity findVetById(@Param("vet_id") Long vetId);
}

