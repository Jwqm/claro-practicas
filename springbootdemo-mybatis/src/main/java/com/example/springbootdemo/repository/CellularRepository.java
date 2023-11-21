package com.example.springbootdemo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springbootdemo.mapper.CellularMapper;
import com.example.springbootdemo.model.entities.Cellular;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CellularRepository {

    private final CellularMapper cellularMapper;

    public Cellular findByCellularNumber(String cellularNumber) {
        return cellularMapper.findByCellularNumber(cellularNumber);
    }

    public Cellular findByCellularNumberAndBusinessType(String cellularNumber, String businessType) {
        return cellularMapper.findByCellularNumberAndBusinessType(cellularNumber, businessType);
    }

    public List<Cellular> findAll() {
        return cellularMapper.findAll();
    }

    public void save(Cellular cellular) {
        cellularMapper.save(cellular);
    }
}
