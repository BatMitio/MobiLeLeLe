package bg.softuni.mobilelele.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "brands")
public class Brand extends ID{
    @Column(unique = true, nullable = false)
    private String name;
    private LocalDate created;
    private LocalDate modified;

    public Brand() {
    }

    public Brand(String name, LocalDate created, LocalDate modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
