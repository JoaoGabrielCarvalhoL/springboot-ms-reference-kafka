package br.com.carv.carstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_owner")
public class OwnerPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String contactNumber;
    @OneToMany(mappedBy = "ownerPostEntity")
    private List<CarPostEntity> cars;

    public OwnerPostEntity() {}

    public OwnerPostEntity(String name, String type, String contactNumber) {
        this.name = name;
        this.type = type;
        this.contactNumber = contactNumber;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<CarPostEntity> getCars() {
        return cars;
    }

    public void setCars(List<CarPostEntity> cars) {
        this.cars = cars;
    }
}
