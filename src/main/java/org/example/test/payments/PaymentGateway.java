package org.example.test.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
