package com.alix.ecommerce.kafka;

import com.alix.ecommerce.customer.CustomerResponse;
import com.alix.ecommerce.order.PaymentMethod;
import com.alix.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
