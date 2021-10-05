package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.entity.enumerated.Category;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Category category;
    @Column(nullable = true, length = 1024)
    private String imageUrl;
    @Column(nullable = true)
    private Integer startYear;
    @Column(nullable = true)
    private Integer endYear;
    @ManyToOne(optional = true)
    private Brand brand;

    public Model() {
    }

    public Model(String name, Category category, String imageUrl, Integer startYear, Integer endYear, Brand brand) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Model setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Model setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Model setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
