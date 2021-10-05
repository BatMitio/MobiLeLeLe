package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.enumerated.Engine;
import bg.softuni.mobilelele.model.entity.enumerated.Transmission;

public class OfferSummaryView {
    private String description;
    private Engine engine;
    private String imageUrl;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;
    private String brand;
    private String model;

    public String getDescription() {
        return description;
    }

    public OfferSummaryView setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferSummaryView setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSummaryView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferSummaryView setPrice(int price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferSummaryView setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummaryView setYear(int year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferSummaryView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferSummaryView setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
