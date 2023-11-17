package dev.radom.restaurant.api.order.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(name = "order_code", length = 30, unique = true, nullable = false)
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderDate;

    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "crew_id",nullable = false)
    private Crew crew;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

}
