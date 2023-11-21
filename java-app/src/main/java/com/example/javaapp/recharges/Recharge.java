package com.example.javaapp.recharges;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recharge {
    private Float amount;
    private String cardId;
    private String channel;
    private String reason;
    private LocalDateTime date;
}
