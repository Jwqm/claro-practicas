package com.example.javaapp.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.example.javaapp.recharges.Recharge;

public class ClientRechargesToday implements IOperationCellularRecharges {

    @Override
    public Long countRecharges(List<Recharge> recharges) {
        return recharges
                .stream()
                .filter(isDateNow())
                .count();
    }

    @Override
    public LocalDateTime lastRechargeDate(List<Recharge> recharges) {
        return recharges.stream()
                .max(Comparator.comparing(Recharge::getDate))
                .filter(isDateNow())
                .map(Recharge::getDate)
                .orElse(null);
    }

    public static Predicate<Recharge> isDateNow() {
        return recharge -> recharge.getDate().toLocalDate().isEqual(LocalDate.now());
    }

}
