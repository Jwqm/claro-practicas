package com.example.springbootdemo.mapper.ccard;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.springbootdemo.model.entities.PrepayCellulars;

@Mapper
public interface PrepayCellularMapper {
    @Select("SELECT PCE_CLU_CELLULAR_NUMBER as cellularNumber, PCE_HANDLE as handle FROM PREPAY_CELLULARS WHERE PCE_CLU_CELLULAR_NUMBER = #{cellularNumber}")
    PrepayCellulars findByCellularNumber(@Param("cellularNumber") String cellularNumber);
}
