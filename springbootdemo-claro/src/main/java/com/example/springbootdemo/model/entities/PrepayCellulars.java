package com.example.springbootdemo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrepayCellulars {
    private String cellularNumber;
    private String handle;
}
