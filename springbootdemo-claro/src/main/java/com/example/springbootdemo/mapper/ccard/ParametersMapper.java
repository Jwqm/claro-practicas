package com.example.springbootdemo.mapper.ccard;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.springbootdemo.model.entities.Parameter;

@Mapper
public interface ParametersMapper {
    @Select("SELECT PPA_NAME as name, PPA_VALUE as value FROM PREPAY_PARAMETERS WHERE PPA_NAME = #{name} AND SYSDATE BETWEEN PPA_START_DATE AND NVL(PPA_END_DATE, SYSDATE+1)")
    Parameter findByName(@Param("name") String name);
}
