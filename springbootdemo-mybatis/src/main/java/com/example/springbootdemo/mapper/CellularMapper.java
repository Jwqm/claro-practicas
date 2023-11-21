package com.example.springbootdemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.springbootdemo.model.entities.Cellular;

@Mapper
public interface CellularMapper {
    //Forma 1: renombrar cada columna con el mismo nombre de atributo
    @Select("SELECT CELLULAR_NUMBER as cellularNumber, BILL_NUMBER as billNumber, BUSINESS_TYPE as businessType FROM CELLULAR WHERE CELLULAR_NUMBER = #{cellularNumber}")
    Cellular findByCellularNumber(@Param("cellularNumber") String cellularNumber);

    //Forma 2: utilizar results para el mapeo de datos solo con MyBatis
    /*@Select("SELECT * FROM CELLULAR WHERE CELLULAR_NUMBER = #{cellularNumber}")
    @Results({
        @Result(property = "cellularNumber", column = "CELLULAR_NUMBER"),
        @Result(property = "billNumber", column = "BILL_NUMBER"),
        @Result(property = "businessType", column = "BUSINESS_TYPE")
    })
    Cellular findByCellularNumber(@Param("cellularNumber") String cellularNumber);*/

    @Select("SELECT CELLULAR_NUMBER as cellularNumber, BILL_NUMBER as billNumber, BUSINESS_TYPE as businessType "+
    " FROM CELLULAR WHERE CELLULAR_NUMBER = #{cellularNumber} AND BUSINESS_TYPE = #{businessType}")
    Cellular findByCellularNumberAndBusinessType(@Param("cellularNumber") String cellularNumber, @Param("businessType") String businessType);

    @Select("SELECT CELLULAR_NUMBER as cellularNumber, BILL_NUMBER as billNumber, BUSINESS_TYPE as businessType "+
    " FROM CELLULAR")
    List<Cellular> findAll();

    @Insert("INSERT INTO CELLULAR (CELLULAR_NUMBER, BILL_NUMBER, BUSINESS_TYPE, PLAN_ID) " +
            "VALUES (#{cellularNumber}, #{billNumber}, #{businessType}, #{planId})")
    @Options(useGeneratedKeys = true, keyProperty = "cellularNumber")
    int save(Cellular cellular);
}
