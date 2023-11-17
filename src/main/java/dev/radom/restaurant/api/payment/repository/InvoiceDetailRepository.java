package dev.radom.restaurant.api.payment.repository;

import dev.radom.restaurant.api.payment.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {
    Optional<InvoiceDetail> findInvoiceDetailByInvoice_Uuid(String uuid);

}
