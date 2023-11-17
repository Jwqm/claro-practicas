package com.example.springbootdemo.repository.memory;

import java.util.List;

import com.example.springbootdemo.model.Cellular;

public interface CellularRepository {
    List<Cellular> find();

    Cellular findBy(String cellularNumber);

    void save(Cellular cellular);
}
