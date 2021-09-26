package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enumerated.Engine;
import bg.softuni.mobilelele.model.enumerated.Transmission;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    @Column(nullable = true)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Engine engine;
    @Column(nullable = true)
    private String imageUrl;
    @Column(nullable = true)
    private Integer mileage;
    @Column(nullable = true)
    private Double price;
    @Column(nullable = true)
    private Transmission transmission;
    @Column(nullable = true)
    private Integer year;
    @ManyToOne(optional = true)
    private Model model;
    @ManyToOne(optional = true)
    private User seller;

    public Offer() {
    }

    public Offer(String description, Engine engine, String imageUrl, Integer mileage, Double price, Transmission transmission, Integer year, Model model, User seller) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public Offer setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Offer setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Offer setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Offer setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Offer setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Offer setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Model getModel() {
        return model;
    }

    public Offer setModel(Model model) {
        this.model = model;
        return this;
    }

    public User getSeller() {
        return seller;
    }

    public Offer setSeller(User seller) {
        this.seller = seller;
        return this;
    }
}
