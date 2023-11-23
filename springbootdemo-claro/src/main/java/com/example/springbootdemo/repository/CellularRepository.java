package com.example.springbootdemo.repository;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.claro.amx.sp.commonslib.exception.impl.DataBaseException;
import com.claro.amx.sp.commonslib.exception.impl.TechnicalException;
import com.example.springbootdemo.mapper.prod.CellularMapper;
import com.example.springbootdemo.model.entities.Cellular;
import static com.claro.amx.sp.commonslib.constants.Errors.ERROR_DATABASE_GENERAL;
import static com.claro.amx.sp.commonslib.constants.Errors.ERROR_DATABASE_GENERAL_NOT_FOUND;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CellularRepository {

    private final CellularMapper cellularMapper;

    public Cellular findByCellularNumber(String cellularNumber) {
        try {
            var cellular = cellularMapper.findByCellularNumber(cellularNumber);
            if(Objects.isNull(cellular)) throw new TechnicalException(ERROR_DATABASE_GENERAL_NOT_FOUND.getCode(), ERROR_DATABASE_GENERAL_NOT_FOUND.getMessage());
            return cellular;
        } catch(TechnicalException technicalException) {
            throw technicalException;
        } catch(Exception exception) {
            throw new DataBaseException(ERROR_DATABASE_GENERAL.getCode(), String.format(ERROR_DATABASE_GENERAL.getMessage(), exception.getClass().getSimpleName(), exception.getCause()));
        }

    }

    public Cellular findByCellularNumberAndBusinessType(String cellularNumber, String businessType) {
        return cellularMapper.findByCellularNumberAndBusinessType(cellularNumber, businessType);
    }

    public List<Cellular> findAll() {
        return cellularMapper.findAll();
    }

    public int save(Cellular cellular) {
        return cellularMapper.save(cellular);
    }
}
