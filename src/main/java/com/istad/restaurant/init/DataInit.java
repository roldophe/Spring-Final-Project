package com.istad.restaurant.init;

import com.istad.restaurant.api.menu.Item;
import com.istad.restaurant.api.menu.ItemRepository;
import com.istad.restaurant.api.menu.Menu;
import com.istad.restaurant.api.menu.MenuRepository;
import com.istad.restaurant.api.order.model.Crew;
import com.istad.restaurant.api.order.model.Customer;
import com.istad.restaurant.api.order.repository.CrewRepository;
import com.istad.restaurant.api.order.repository.CustomerRepository;
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
//                .email("radom123G@gmail.com")
//                .address("Pnhom Penh")
//                .build());
//        crewRepository.save(Crew.builder()
//                .uuid(UUID.randomUUID().toString())
//                .firstName("James")
//                .lastName("Bond")
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
//                .contact("+536198745")
//                .address("Pnhom Penh")
//                .build());
    }
}