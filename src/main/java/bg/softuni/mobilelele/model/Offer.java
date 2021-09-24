package bg.softuni.mobilelele.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends ID {
    private String description;
    @Enumerated(EnumType.STRING)
    private Engine engine;
    private String imageUrl;
    private int mileage;
    private Double price;
    private Transmission transmission;
    private int year;
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToOne
    private Model model;
    @ManyToOne
    private User seller;
}
