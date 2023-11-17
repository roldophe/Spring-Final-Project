package dev.radom.restaurant.api.payment.repository;

import dev.radom.restaurant.api.payment.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
