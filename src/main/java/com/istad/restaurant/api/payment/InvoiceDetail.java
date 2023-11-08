package com.istad.restaurant.api.payment;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "tax_rates")
    private Integer tax;
    @Column(name = "sub_total")
    private BigDecimal subTotal;

    @Column(name = "sales_tax")
    private BigDecimal salesTax;
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
