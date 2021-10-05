package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/offers/all")
public class AllOffersController {
    private final OfferService offerService;

    public AllOffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public String allOffers(Model model){
        List<OfferSummaryView> offers = offerService.getAllOffers();
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }
}
