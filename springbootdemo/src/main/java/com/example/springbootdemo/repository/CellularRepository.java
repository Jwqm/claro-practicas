package com.example.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootdemo.model.Cellular;

@Repository
public interface CellularRepository extends JpaRepository<Cellular, String> {
    // Método para buscar por ID
    Cellular findByCellularNumber(String cellularNumber);

    // Método para buscar por nombre (o cualquier otro campo)
    List<Cellular> findByBusinessType(String businessType);

    // Metodo con multiples consultas derivadas por diferentes campos
    Cellular findByCellularNumberAndBusinessType(String cellularNumber, String businessType);

    // Método para obtener todos los registros
    List<Cellular> findAll();
}
