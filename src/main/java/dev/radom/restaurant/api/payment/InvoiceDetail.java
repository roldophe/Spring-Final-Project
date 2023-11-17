package dev.radom.restaurant.api.payment;

import jakarta.persistence.*;
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
    @Column(name = "sub_total")
    private BigDecimal subTotal;
    @Column(name = "disc_Amount")
    private BigDecimal discAmt;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
    private BigDecimal finalTotal;
}
