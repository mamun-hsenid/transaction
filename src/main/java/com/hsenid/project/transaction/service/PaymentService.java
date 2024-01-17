package com.hsenid.project.transaction.service;

import com.hsenid.project.transaction.model.PaymentInfo;

public interface PaymentService {
    void transferBalance(PaymentInfo paymentInfo);
}
