package ro.fasttrackit.vetclinic.model.entity;

import ro.fasttrackit.vetclinic.model.Species;

import javax.persistence.*;
import java.util.List;

@Entity(name = "pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;
    @Column(name = "pet_name")
    private String name;
    @Column(name = "pet_species")
    @Enumerated(EnumType.STRING)
    private Species type;

    @ManyToMany(mappedBy = "owner")
    private List<OwnerEntity> owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private List<ConsultationEntity> consultation;

    public List<ConsultationEntity> getConsultation() {
        return consultation;
    }

    public void setConsultation(List<ConsultationEntity> consultation) {
        this.consultation = consultation;
    }

    public List<OwnerEntity> getOwner() {
        return owner;
    }

    public void setOwner(List<OwnerEntity> owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getType() {
        return type;
    }

    public void setType(Species type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PetEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", owner=" + owner +
                ", consultation=" + consultation +
                '}';
    }
}
