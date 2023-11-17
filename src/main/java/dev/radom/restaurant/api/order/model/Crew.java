package dev.radom.restaurant.api.order.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Entity
@Table
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uuid;
    /**
     * check:
     * if (first_name = 1)
     * if (last_name = 1)
     * if(dob=1)
     * throw new (taken);
     */
    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @Column(nullable = false, length = 6)
    private String gender;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dob;
    private Integer age;

    @Column(name = "contact_number", length = 20, nullable = false)
    private String contact;

    @Column(nullable = false)
    private String address;

    @Column(unique = true, length = 80, nullable = false)
    private String email;

    @Column(name = "is_working", nullable = false)
    private Boolean isWorking;

    @OneToMany(mappedBy = "crew")
    private List<Order> orders;

}
