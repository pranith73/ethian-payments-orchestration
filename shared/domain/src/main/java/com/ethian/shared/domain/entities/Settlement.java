package com.ethian.shared.domain.entities;

import com.ethian.shared.domain.entities.support.SettlementStatus;
import com.ethian.shared.domain.identifiers.MerchantId;
import com.ethian.shared.domain.identifiers.SettlementId;
import com.ethian.shared.domain.valueobjects.BusinessDate;
import com.ethian.shared.domain.valueobjects.Money;

import java.util.Objects;

public final class Settlement {

    private final SettlementId settlementId; // as per Section 2.1: settlementId (UUID)
    private final MerchantId merchantId;

    private final String paymentIds; // simplified placeholder for now
    private final Money totalAmount;

    private final SettlementStatus status;
    private final BusinessDate settlementDate;

    private Settlement(SettlementId settlementId,
                       MerchantId merchantId,
                       String paymentIds,
                       Money totalAmount,
                       SettlementStatus status,
                       BusinessDate settlementDate) {

        this.settlementId = Objects.requireNonNull(settlementId, "settlementId");
        this.merchantId = Objects.requireNonNull(merchantId, "merchantId");
        this.paymentIds = Objects.requireNonNullElse(paymentIds, "").trim();
        this.totalAmount = Objects.requireNonNull(totalAmount, "totalAmount");
        this.status = Objects.requireNonNull(status, "status");
        this.settlementDate = Objects.requireNonNull(settlementDate, "settlementDate");
    }

    public static Settlement of(SettlementId settlementId,
                                MerchantId merchantId,
                                String paymentIds,
                                Money totalAmount,
                                SettlementStatus status,
                                BusinessDate settlementDate) {
        return new Settlement(settlementId, merchantId, paymentIds, totalAmount, status, settlementDate);
    }

    public SettlementId settlementId() { return settlementId; }
    public MerchantId merchantId() { return merchantId; }
    public String paymentIds() { return paymentIds; }
    public Money totalAmount() { return totalAmount; }
    public SettlementStatus status() { return status; }
    public BusinessDate settlementDate() { return settlementDate; }
}
