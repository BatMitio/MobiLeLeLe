package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Model> models;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    public Set<Model> getModels() {
        return models;
    }

    public Brand setModels(Set<Model> models) {
        this.models = models;
        return this;
    }

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }
}
