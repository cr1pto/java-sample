package com.cr1pto.sample.requests;

import java.math.BigDecimal;
import java.util.Date;

import com.cr1pto.sample.entities.PaymentType;

public class PaymentRequest {
    private BigDecimal amount;
    private Date paymentDate;
    private PaymentType paymentType;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
