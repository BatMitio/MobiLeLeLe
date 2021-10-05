package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {
    void initialize();

    List<OfferSummaryView> getAllOffers();
}
