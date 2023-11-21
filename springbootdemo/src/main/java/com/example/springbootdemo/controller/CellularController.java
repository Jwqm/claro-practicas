package com.example.springbootdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.dto.CellularDTO;
import com.example.springbootdemo.service.CellularService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cellulars")
@RequiredArgsConstructor
public class CellularController {

    private final CellularService cellularService;

    @GetMapping
    @ResponseBody
    public List<CellularDTO> cellulars() {
        return cellularService.findAll();
    }

    @GetMapping("/{cellularNumber}")
    @ResponseBody
    public CellularDTO cellulars(@PathVariable("cellularNumber") String cellularNumber) {
        return cellularService.findByCellularNumber(cellularNumber);
    }

    @PostMapping
    @ResponseBody
    public String cellulars(@RequestBody CellularDTO cellularDTO) {
        cellularService.save(cellularDTO);
        return "OK";
    }
}