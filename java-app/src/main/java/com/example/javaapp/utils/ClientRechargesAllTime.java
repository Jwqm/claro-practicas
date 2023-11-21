package com.example.javaapp.utils;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import com.example.javaapp.recharges.Recharge;

public class ClientRechargesAllTime implements IOperationCellularRecharges {

    @Override
    public Long countRecharges(List<Recharge> recharges) {
        return recharges
                .stream()
                .count();
    }

    @Override
    public LocalDateTime lastRechargeDate(List<Recharge> recharges) {
        return recharges.stream()
                .max(Comparator.comparing(Recharge::getDate))
                .filter(Objects::nonNull)
                .map(Recharge::getDate)
                .orElse(null);
    }

}
