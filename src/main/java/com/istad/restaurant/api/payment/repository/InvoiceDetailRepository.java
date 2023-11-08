package com.istad.restaurant.api.payment.repository;

import com.istad.restaurant.api.payment.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {

}
