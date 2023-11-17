package dev.radom.restaurant.api.payment.repository;

import dev.radom.restaurant.api.payment.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {

}
