package com.example.springbootdemo.controller;

import java.util.List;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/cellulars")
@RequiredArgsConstructor
@Slf4j
public class CellularController {

    private final CellularService cellularService;

    @GetMapping
    @Operation(summary = "Obtener todos los celulares")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CellularDTO.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<CellularDTO> cellulars() {
        return cellularService.findAll();
    }

    @GetMapping("/{cellularNumber}")
    @Operation(summary = "Obtener un celular por número")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CellularDTO.class))),
            @ApiResponse(responseCode = "404", description = "Celular no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public CellularDTO cellulars(@PathVariable("cellularNumber") String cellularNumber) {
        var cellularDTO = cellularService.findByCellularNumber(cellularNumber);
        log.info("Se ha procesado una solicitud en /api/v1/cellulars/{}: {}", cellularNumber, cellularDTO);
        return cellularDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un nuevo celular")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Celular creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public void cellulars(@RequestBody CellularDTO cellularDTO) {
        cellularService.save(cellularDTO);
    }
}