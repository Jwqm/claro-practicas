package com.example.springbootdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootdemo.model.dto.CellularDTO;
import com.example.springbootdemo.model.entities.Cellular;
import com.example.springbootdemo.repository.CellularRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CellularService {

    private final CellularRepository cellularRepository;

    public List<CellularDTO> findAll() {
        return cellularRepository.findAll().stream().map(this::toCellularDTO).toList();
    }

    public CellularDTO findByCellularNumber(String cellularNumber) {
        return toCellularDTO(cellularRepository.findByCellularNumber(cellularNumber));
    }

    public void save(CellularDTO cellularDTO) {
        cellularRepository.save(toCellular(cellularDTO));
    }

    private CellularDTO toCellularDTO(Cellular cellular) {
        return CellularDTO.builder()
                .cellularNumber(cellular.getCellularNumber())
                .businessType(cellular.getBusinessType())
                .build();
    }

    private Cellular toCellular(CellularDTO cellularDTO) {
        return Cellular.builder()
                .cellularNumber(cellularDTO.getCellularNumber())
                .businessType(cellularDTO.getBusinessType())
                .build();
    }

}
