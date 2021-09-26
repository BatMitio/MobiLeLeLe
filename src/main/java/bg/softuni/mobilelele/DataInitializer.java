package bg.softuni.mobilelele;

import bg.softuni.mobilelele.model.entity.Brand;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.enumerated.Category;
import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.model.enumerated.Role;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        initModelsAndBrands();
        initUsers();
    }

    private void initUsers(){
        if(userRepository.count() == 0) {
            UserRole adminRole = new UserRole().setName(Role.ADMIN);
            UserRole userRole = new UserRole().setName(Role.USER);
            User admin = new User();
            admin
                    .setActive(true)
                    .setUsername("admin")
                    .setFirstName("Admin").setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("test"))
                    .setRoles(new HashSet<>(List.of(adminRole, userRole)));
            userRepository.saveAndFlush(admin);
        }
    }

    private void initModelsAndBrands(){
        if(brandRepository.count() == 0){
            Brand opel = new Brand("Opel");
            Brand ford = new Brand("Ford");
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
            opel.setModels(Set.of(astra, vectra));
            ford.setModels(Set.of(mustang, focus));

            brandRepository.saveAllAndFlush(List.of(opel, ford));
        }

    }
}
