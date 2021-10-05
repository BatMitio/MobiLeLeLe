package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.Brand;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void initialize() {
        if(brandRepository.count() == 0){
            Brand opel = new Brand().setName("Opel");
            Brand ford = new Brand().setName("Ford");

            this.brandRepository.saveAll(List.of(opel, ford));
        }
    }
}
