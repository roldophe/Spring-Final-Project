package dev.radom.restaurant.init;

import dev.radom.restaurant.api.menu.Menu;
import dev.radom.restaurant.api.menu.MenuRepository;
import dev.radom.restaurant.api.order.model.Crew;
import dev.radom.restaurant.api.order.model.Customer;
import dev.radom.restaurant.api.order.repository.CrewRepository;
import dev.radom.restaurant.api.order.repository.CustomerRepository;
import dev.radom.restaurant.api.user.Authority;
import dev.radom.restaurant.api.user.AuthorityRepository;
import dev.radom.restaurant.api.user.Role;
import dev.radom.restaurant.api.user.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInit {
    private final MenuRepository menuRepository;
    private final CrewRepository crewRepository;
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
//
//    @PostConstruct
//    void init() {
//        Authority readMenu = new Authority();
//        readMenu.setName("menu:read");
//        Authority writeMenu = new Authority();
//        writeMenu.setName("manu:write");
//        Authority updateMenu = new Authority();
//        updateMenu.setName("manu:update");
//        Authority deleteMenu = new Authority();
//        deleteMenu.setName("menu:delete");
//        Set<Authority> authorityMenus = Set.of(
//                readMenu, writeMenu, updateMenu, deleteMenu
//        );
//        authorityRepository.saveAll(authorityMenus);
//
//        Authority readOrder = new Authority();
//        readOrder.setName("order:read");
//        Authority writeOrder = new Authority();
//        writeOrder.setName("order:write");
//        Authority updateOrder = new Authority();
//        updateOrder.setName("order:update");
//        Authority deleteOrder = new Authority();
//        deleteOrder.setName("order:delete");
//        Set<Authority> authorityOrders = Set.of(
//                readOrder, writeOrder, updateOrder, deleteOrder
//        );
//        authorityRepository.saveAll(authorityOrders);
//
//        Authority readInvoice = new Authority();
//        readInvoice.setName("invoice:read");
//        Authority writeInvoice = new Authority();
//        writeInvoice.setName("invoice:write");
//        Authority updateInvoice = new Authority();
//        updateInvoice.setName("invoice:update");
//        Authority deleteInvoice = new Authority();
//        deleteInvoice.setName("invoice:delete");
//        Set<Authority> authorityInvoices = Set.of(
//                readInvoice, writeInvoice, updateInvoice, deleteInvoice
//        );
//        authorityRepository.saveAll(authorityInvoices);
//
//        Authority readUser = new Authority();
//        readUser.setName("user:read");
//        Authority writeUser = new Authority();
//        writeUser.setName("user:write");
//        Authority updateUser = new Authority();
//        updateUser.setName("user:update");
//        Authority deleteUser = new Authority();
//        deleteUser.setName("user:delete");
//        Authority profileUser = new Authority();
//        profileUser.setName("user:profile");
//        Set<Authority> authorityUsers = Set.of(
//                readUser, writeUser, updateUser, deleteUser, profileUser
//        );
//        authorityRepository.saveAll(authorityUsers);
//        Set<Authority> fullAuthorities = new HashSet<>() {{
//            addAll(authorityUsers);
//            addAll(authorityInvoices);
//            addAll(authorityOrders);
//            addAll(authorityMenus);
//        }};
//        authorityRepository.saveAll(fullAuthorities);
//        Role adminRole = new Role();
//        adminRole.setName("ADMIN");
//        adminRole.setAuthorities(fullAuthorities);
//
//        Role crewRole = new Role();
//        crewRole.setName("CREW");
//        crewRole.setAuthorities(new HashSet<>() {{
//            addAll(authorityInvoices);
//            addAll(authorityOrders);
//            addAll(authorityMenus);
//            add(profileUser);
//        }});
//        Role customerRole = new Role();
//        customerRole.setName("CUSTOMER");
//        customerRole.setAuthorities(Set.of(
//                readMenu, writeOrder, readInvoice, profileUser
//        ));
//        roleRepository.saveAll(List.of(adminRole, crewRole, customerRole));
//
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
//    }
}