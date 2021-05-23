package com.example.second.service.impl;

import com.example.second.dao.KcMapper;
import com.example.second.dao.StudentCopyDao;
import com.example.second.dao.StudentCountDao;
import com.example.second.dao.StudentDao;
import com.example.second.entity.Kc;
import com.example.second.entity.KcExample;
import com.example.second.entity.Student;
import com.example.second.service.KcService;
import com.example.second.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
//@Transactional(rollbackFor = Exception.class)
public class KcServiceBean implements KcService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentCountDao studentCountDao;

    @Autowired
    private KcMapper kcMapper;

//    @Autowired
    StudentCopyDao studentCopyDao;

    public List<Kc> findAll(Kc kc) {
        KcExample kcExample = new KcExample();
        kcExample.createCriteria().andKcnameEqualTo(kc.getKcname());
        kcMapper.selectByExample(kcExample);
        return  kcMapper.selectByExample(kcExample);
    }

    public List<Kc> findAll() {
        return  kcMapper.selectAll();
    }


    @Transactional
    public void addKc(Kc kc) {
        kcMapper.insert(kc);
    }

    public void deleteKc(Integer id) {
        Kc kc = new Kc();
        kc.setId(id);
        kc.setIsdelete("1");
        kcMapper.updateByPrimaryKeySelective(kc);
    }


    public void deleteStudentById(Long uid) {
        this.studentDao.deleteStudentById(uid);
        Integer count = this.studentDao.getCountStudents();
        this.studentCountDao.addCount(count);
    }

    public void updateKc( Kc kc) {
        this.kcMapper.updateByPrimaryKeySelective(kc);
    }

    public List<Kc> findKcByName(String kcname) {
        return this.kcMapper.findKcByName("%"+kcname+"%");
    }

    public Integer deleteKcs(Integer[] ids) {
        for (int a = 0; a < ids.length; a++) {
            this.deleteKc(ids[a]);
        }
        return ids.length;
    }

}
