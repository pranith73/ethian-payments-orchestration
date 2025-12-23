package com.ethian.shared.domain.entities;

import com.ethian.shared.domain.identifiers.MerchantId;

import java.util.Objects;

public final class Merchant {

    private final MerchantId merchantId;
    private final String merchantName;

    // placeholders from Section 2.1 attributes (modeled as opaque strings for now)
    private final String merchantSettings;
    private final String processorCredentials;
    private final String settlementConfig;

    private Merchant(MerchantId merchantId,
                     String merchantName,
                     String merchantSettings,
                     String processorCredentials,
                     String settlementConfig) {

        this.merchantId = Objects.requireNonNull(merchantId, "merchantId");
        this.merchantName = requireNonBlank(merchantName, "merchantName");
        this.merchantSettings = requireNonBlank(merchantSettings, "merchantSettings");
        this.processorCredentials = requireNonBlank(processorCredentials, "processorCredentials");
        this.settlementConfig = requireNonBlank(settlementConfig, "settlementConfig");
    }

    public static Merchant of(MerchantId merchantId,
                              String merchantName,
                              String merchantSettings,
                              String processorCredentials,
                              String settlementConfig) {
        return new Merchant(merchantId, merchantName, merchantSettings, processorCredentials, settlementConfig);
    }

    public MerchantId merchantId() { return merchantId; }
    public String merchantName() { return merchantName; }
    public String merchantSettings() { return merchantSettings; }
    public String processorCredentials() { return processorCredentials; }
    public String settlementConfig() { return settlementConfig; }

    private static String requireNonBlank(String v, String name) {
        if (v == null || v.isBlank()) throw new IllegalArgumentException(name + " cannot be null/blank");
        return v.trim();
    }
}
