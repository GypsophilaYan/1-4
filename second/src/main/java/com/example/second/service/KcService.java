package com.example.second.service;

import com.example.second.entity.Kc;
import com.example.second.entity.Student;

import java.util.List;


public interface KcService {

    public List<Kc> findAll(Kc kc);

    public List<Kc> findAll();

    public void addKc(Kc kc);

    public void deleteKc(Integer id);

    public void deleteStudentById(Long uid);

    public void updateKc( Kc kc);

    List<Kc> findKcByName(String kcname);

    public Integer deleteKcs(Integer[] ids);
}
