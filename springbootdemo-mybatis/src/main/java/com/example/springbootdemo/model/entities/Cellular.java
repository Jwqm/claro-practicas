package com.example.springbootdemo.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cellular {
    @Id
    private String cellularNumber;
    private String billNumber;
    private String businessType;
    private String planId;
}
