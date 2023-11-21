package com.example.javaapp.cellulars;

import java.time.LocalDateTime;
import java.util.List;

import com.example.javaapp.recharges.Recharge;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CellularRecharges {
    private String clientId;
    private LocalDateTime lastRechargeDate;
    private Long count;
    private List<Recharge> recharges;
}
