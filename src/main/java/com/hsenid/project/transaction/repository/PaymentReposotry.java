package com.hsenid.project.transaction.repository;

import com.hsenid.project.transaction.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentReposotry extends JpaRepository<PaymentInfo, String> {
    PaymentInfo save(PaymentInfo paymentInfo);
}
