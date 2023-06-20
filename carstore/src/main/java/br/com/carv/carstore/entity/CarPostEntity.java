package br.com.carv.carstore.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_car")
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String engineVersion;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private LocalDate createdDate;
    @Column(nullable = false)
    private String contact;
    @ManyToOne
    private OwnerPostEntity ownerPostEntity;

    public CarPostEntity() {}

    public CarPostEntity(String model, String brand, BigDecimal price, String description, String engineVersion,
                         String city, LocalDate createdDate, String contact, OwnerPostEntity ownerPostEntity) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.engineVersion = engineVersion;
        this.city = city;
        this.createdDate = createdDate;
        this.contact = contact;
        this.ownerPostEntity = ownerPostEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public OwnerPostEntity getOwnerPostEntity() {
        return ownerPostEntity;
    }

    public void setOwnerPostEntity(OwnerPostEntity ownerPostEntity) {
        this.ownerPostEntity = ownerPostEntity;
    }
}
