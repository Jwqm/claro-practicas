package com.example.javaapp.cellulars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class CellularClient extends Cellular {
    private String id;
    private String firstName;
    private String secondName;
    private Integer dni;
}
