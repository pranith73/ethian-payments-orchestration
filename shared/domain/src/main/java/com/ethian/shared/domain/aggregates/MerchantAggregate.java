package com.ethian.shared.domain.aggregates;

import com.ethian.shared.domain.entities.LedgerEntry;
import com.ethian.shared.domain.entities.Merchant;
import com.ethian.shared.domain.entities.Settlement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Section 2.4 - MerchantAggregate
 * Consistency boundary for merchant-scoped records.
 *
 * Owns:
 * - Merchant (root)
 * - LedgerEntries (merchant-scoped, append-only)
 * - Settlements (merchant-scoped, append-only)
 */
public final class MerchantAggregate {

    private final Merchant merchant;

    private final List<LedgerEntry> ledgerEntries = new ArrayList<>();
    private final List<Settlement> settlements = new ArrayList<>();

    private MerchantAggregate(Merchant merchant) {
        this.merchant = Objects.requireNonNull(merchant, "merchant");
    }

    public static MerchantAggregate from(Merchant merchant) {
        return new MerchantAggregate(merchant);
    }

    public Merchant merchant() {
        return merchant;
    }

    public List<LedgerEntry> ledgerEntries() {
        return Collections.unmodifiableList(ledgerEntries);
    }

    public List<Settlement> settlements() {
        return Collections.unmodifiableList(settlements);
    }

    public void appendLedgerEntry(LedgerEntry entry) {
        ledgerEntries.add(Objects.requireNonNull(entry, "entry"));
    }

    public void appendSettlement(Settlement settlement) {
        settlements.add(Objects.requireNonNull(settlement, "settlement"));
    }
}
