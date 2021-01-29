package ro.fasttrackit.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.vetclinic.model.entity.OwnerEntity;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
    @Query("select o from owner o where o.id= :owner_id")
    Optional<OwnerEntity> findOwnerById(@Param("owner_id") Long ownerId);
}
