package com.example.springbootdemo.repository.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.springbootdemo.model.Cellular;

@Repository
public class CellularRepositoryImpl implements CellularRepository {

    private static Map<String, Cellular> cellularMap = initCellulars(); 

    @Override
    public List<Cellular> find() {
        return cellularMap.values().stream().toList();
    }

    @Override
    public Cellular findBy(String cellularNumber) {
        return cellularMap.values().stream().filter(cellular -> cellular.getCellularNumber().equalsIgnoreCase(cellularNumber)).findFirst().get();
    }

    private static Map<String, Cellular> initCellulars() {
        return new HashMap<String, Cellular>(
            Map.of("1", Cellular.builder().cellularNumber("1").businessType("PP").build(), 
            "2", Cellular.builder().cellularNumber("2").businessType("CR").build()));
    }

    @Override
    public void save(Cellular cellular) {
        cellularMap.put(cellular.getCellularNumber(), cellular);
    }

}
