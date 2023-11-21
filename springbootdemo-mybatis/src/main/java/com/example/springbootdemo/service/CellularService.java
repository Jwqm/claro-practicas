package com.example.springbootdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.springbootdemo.model.dto.CellularDTO;
import com.example.springbootdemo.model.entities.Cellular;
import com.example.springbootdemo.repository.CellularRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CellularService {

    private final CellularRepository cellularRepository;

    public List<CellularDTO> findAll() {
        return cellularRepository.findAll().stream().map(this::toCellularDTO).toList();
    }

    public CellularDTO findByCellularNumber(String cellularNumber) {
        long start = System.currentTimeMillis();
        log.debug("Iniciando busqueda por numero de celular: {}", cellularNumber);
        var cellularDTO = toCellularDTO(cellularRepository.findByCellularNumber(cellularNumber));
        log.debug("Conversion de entidad a DTO completada {}", cellularDTO);
        log.debug("Tiempo de operacion metodo findByCellularNumber {} ms.", System.currentTimeMillis() -start);
        return cellularDTO;
    }

    public int save(CellularDTO cellularDTO) {
        return cellularRepository.save(toCellular(cellularDTO));
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
