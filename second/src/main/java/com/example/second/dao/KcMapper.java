package com.example.second.dao;

import com.example.second.entity.Kc;
import com.example.second.entity.KcExample;
import java.util.List;

import com.example.second.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Component(value = "KcMapper")
public interface KcMapper {
    long countByExample(KcExample example);

    int deleteByExample(KcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Kc record);

    int insertSelective(Kc record);

    List<Kc> selectByExample(KcExample example);

    Kc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kc record, @Param("example") KcExample example);

    int updateByExample(@Param("record") Kc record, @Param("example") KcExample example);

    int updateByPrimaryKeySelective(Kc record);

    int updateByPrimaryKey(Kc record);

    List<Kc> selectAll();

    List<Kc> findKcByName(String kcname);
}