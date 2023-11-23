package com.example.springbootdemo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cellular {
    private String cellularNumber;
    private String billNumber;
    private String businessType;
    private String planId;
}
