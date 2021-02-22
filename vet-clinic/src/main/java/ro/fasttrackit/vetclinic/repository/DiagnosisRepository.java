package ro.fasttrackit.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.vetclinic.model.entity.DiagnosisEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Long> {
    @Query("select d from diagnosis d where d.id = :diagnosis_id")
    List<DiagnosisEntity> findDiagnosisById(@Param("diagnosis_id") Long diagnosisId);
}
