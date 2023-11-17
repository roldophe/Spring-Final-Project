package dev.radom.restaurant.api.menu;

import dev.radom.restaurant.api.order.model.OrderDetail;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(name = "item_code", length = 30, unique = true, nullable = false)
    private String code;

    @Column(unique = true, nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private BigDecimal price;

    private String image;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "item")
    private Set<OrderDetail> orderDetailList;
}
