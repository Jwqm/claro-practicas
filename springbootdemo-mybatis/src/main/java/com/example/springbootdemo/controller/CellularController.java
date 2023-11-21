package com.example.springbootdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.model.dto.CellularDTO;
import com.example.springbootdemo.service.CellularService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/cellulars")
@RequiredArgsConstructor
@Slf4j
public class CellularController {

    private final CellularService cellularService;

    @GetMapping
    public List<CellularDTO> cellulars() {
        return cellularService.findAll();
    }

    @GetMapping("/{cellularNumber}")
    public CellularDTO cellulars(@PathVariable("cellularNumber") String cellularNumber) {
        var cellularDTO = cellularService.findByCellularNumber(cellularNumber);
        log.info("Se ha procesado una solicitud en /api/v1/cellulars/{}: {}", cellularNumber, cellularDTO);
        return cellularDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cellulars(@RequestBody CellularDTO cellularDTO) {
        cellularService.save(cellularDTO);
    }
}