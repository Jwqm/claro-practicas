package com.example.javaapp.utils;

import java.time.LocalDateTime;
import java.util.List;

import com.example.javaapp.recharges.Recharge;

public interface IOperationCellularRecharges {

    public Long countRecharges(List<Recharge> recharges);

    public LocalDateTime lastRechargeDate(List<Recharge> recharges);

}
