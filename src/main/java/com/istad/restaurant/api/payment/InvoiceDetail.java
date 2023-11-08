package com.istad.restaurant.api.payment;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "disc_Amount")
    private BigDecimal discAmt;
    @Column(name = "sub_total")
    private BigDecimal subTotal;
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
