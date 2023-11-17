package dev.radom.restaurant.api.payment;

import dev.radom.restaurant.api.order.model.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@ToString
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @Column(name = "status")
    private String status;
    private Boolean isPaid;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceDetail> invoiceDetails;
}
