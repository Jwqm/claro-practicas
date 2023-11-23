package com.example.springbootdemo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.ParameterMapper;
import org.springframework.stereotype.Service;

import com.claro.amx.sp.commonslib.constants.BusinessType;
import com.claro.amx.sp.commonslib.exception.impl.BusinessException;
import com.example.springbootdemo.annotations.log.Loggable;
import com.example.springbootdemo.mapper.ccard.ParametersMapper;
import com.example.springbootdemo.mapper.ccard.PrepayCellularMapper;
import com.example.springbootdemo.mapper.prod.CellularMapper;
import com.example.springbootdemo.model.dto.CellularDTO;
import com.example.springbootdemo.model.entities.Cellular;
import com.example.springbootdemo.repository.CellularRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CellularService {

    private final CellularRepository cellularRepository;
    private final PrepayCellularMapper prepayCellularMapper;

    @Loggable
    public List<CellularDTO> findAll() {
        return cellularRepository.findAll().stream().map(this::toCellularDTO).toList();
    }

    @Loggable
    public CellularDTO findByCellularNumber(String cellularNumber, boolean handle) {
        var cellularDTO = toCellularDTO(cellularRepository.findByCellularNumber(cellularNumber));
        if(cellularDTO.getBusinessType().equalsIgnoreCase(BusinessType.CO.name()))
            throw new BusinessException("100001", String.format("Tipo de negocio %s no permitodo en el sistema", cellularDTO.getBusinessType()));
        if(handle) {
            var prepayCellular = prepayCellularMapper.findByCellularNumber(cellularNumber);
            cellularDTO.setHandle(prepayCellular.getHandle());
        }
        return cellularDTO;
    }

    @Loggable
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
