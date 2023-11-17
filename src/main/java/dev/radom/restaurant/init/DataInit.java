package dev.radom.restaurant.init;

import dev.radom.restaurant.api.menu.ItemRepository;
import dev.radom.restaurant.api.menu.Menu;
import dev.radom.restaurant.api.menu.MenuRepository;
import dev.radom.restaurant.api.order.model.Crew;
import dev.radom.restaurant.api.order.model.Customer;
import dev.radom.restaurant.api.order.repository.CrewRepository;
import dev.radom.restaurant.api.order.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInit {
    private final MenuRepository menuRepository;
    private final ItemRepository itemRepository;
    private final CrewRepository crewRepository;
    private final CustomerRepository customerRepository;

    @PostConstruct
    void init() {
//        Menu Drink = Menu.builder()
//                .name("Drinks")
//                .description("soft drinks")
//                .build();
//        Menu Food = Menu.builder()
//                .name("Foods")
//                .description("foods")
//                .build();
//        menuRepository.saveAll(List.of(Drink, Food));
//        crewRepository.save(Crew.builder()
//                .firstName("Radom")
//                .uuid(UUID.randomUUID().toString())
//                .lastName("KHOEM")
//                .dob(LocalDate.now())
//                .contact("+23198745")
//                .age(21)
//                .gender("M")
//                .isWorking(true)
//                .email("radom123G@gmail.com")
//                .address("Pnhom Penh")
//                .build());
//        crewRepository.save(Crew.builder()
//                .uuid(UUID.randomUUID().toString())
//                .firstName("James")
//                .lastName("Bond")
//                .isWorking(true)
//                .dob(LocalDate.now())
//                .contact("+536198745")
//                .gender("M")
//                .email("bond123@gmail.com")
//                .age(31)
//                .address("Pnhom Penh")
//                .build());
//        customerRepository.save(Customer.builder()
//                .firstName("Koko")
//                .uuid(UUID.randomUUID().toString())
//                .lastName("Macha")
//                .dob(LocalDate.now())
//                .age(23)
//                .isDeleted(false)
//                .gender("M")
//                .email("machaasd123@gmail.com")
//                .contact("+536198745")
//                .address("Pnhom Penh")
//                .build());
//        customerRepository.save(Customer.builder()
//                .firstName("Luoiz")
//                .lastName("Enzo")
//                .dob(LocalDate.now())
//                .gender("M")
//                .uuid(UUID.randomUUID().toString())
//                .email("kooko123@gmail.com")
//                .age(34)
//                .isDeleted(false)
//                .contact("+536198745")
//                .address("Pnhom Penh")
//                .build());
    }
}