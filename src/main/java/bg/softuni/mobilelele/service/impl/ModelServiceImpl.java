package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.Brand;
import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.model.entity.enumerated.Category;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public Model add(Model model) {
        return modelRepository.saveAndFlush(model);
    }

    @Override
    public void initialize() {
        if(modelRepository.count() == 0){
            Brand ford = brandRepository.findByName("Ford")
                    .orElseThrow(IllegalArgumentException::new);
            Brand opel = brandRepository.findByName("Opel")
                    .orElseThrow(IllegalArgumentException::new);

            Model astra = new Model("Astra",
                    Category.CAR,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Opel_Astra_1.6_CDTI_ecoFLEX_Dynamic_%28K%29_%E2%80%93_Frontansicht%2C_23._Dezember_2016%2C_D%C3%BCsseldorf_%28cropped%29.jpg/420px-Opel_Astra_1.6_CDTI_ecoFLEX_Dynamic_%28K%29_%E2%80%93_Frontansicht%2C_23._Dezember_2016%2C_D%C3%BCsseldorf_%28cropped%29.jpg",
                    1991,
                    null,
                    opel);
            Model vectra = new Model("Vectra",
                    Category.CAR,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Opel_Vectra_C_2.2_Direkt_front.JPG/420px-Opel_Vectra_C_2.2_Direkt_front.JPG",
                    1988,
                    2008,
                    opel);
            Model mustang = new Model("Mustang",
                    Category.CAR,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/1969_Ford_Mustang_Mach_1_%2837901276352%29.jpg/420px-1969_Ford_Mustang_Mach_1_%2837901276352%29.jpg",
                    1965,
                    null,
                    ford);
            Model focus = new Model("Focus",
                    Category.CAR,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/420px-2018_Ford_Focus_ST-Line_X_1.0.jpg",
                    1998,
                    null,
                    ford);
            modelRepository.saveAll(List.of(astra, vectra, mustang, focus));
        }
    }
}
