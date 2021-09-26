package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepo;

    public ModelServiceImpl(ModelRepository modelRepo) {
        this.modelRepo = modelRepo;
    }

    @Override
    public Model add(Model model) {
        return modelRepo.saveAndFlush(model);
    }
}
