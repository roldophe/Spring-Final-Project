package dev.radom.restaurant.api.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "address")
    private String address;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "status")
    private String status;
}
