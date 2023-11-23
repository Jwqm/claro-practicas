package com.example.springbootdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CellularDTO {
    private String cellularNumber;
    private String businessType;
    private String handle;
}
