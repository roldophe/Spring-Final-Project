package com.istad.restaurant.api.payment;

import com.istad.restaurant.api.order.model.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private String uuid;
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "disc_percetage")
    private Integer discPct;
    @Column(name = "other")
    private BigDecimal other;
    @Column(name = "status")
    private String status;
    private BigDecimal finalTotal;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Boolean isPaid;

}
