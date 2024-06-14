package com.alix.ecommerce.payment;

import com.alix.ecommerce.customer.CustomerResponse;
import com.alix.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
