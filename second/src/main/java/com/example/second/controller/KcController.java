package com.example.second.controller;


import com.example.second.entity.Kc;
import com.example.second.entity.Student;
import com.example.second.service.KcService;
import com.example.second.service.MenuService;
import com.example.second.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kc")
@CrossOrigin(allowCredentials = "true")
public class KcController {

    @Autowired
    private StudentService studentService;

    @Autowired
    MenuService menuService;

    @Autowired
    private KcService kcService;

    /**
     * 查询所有学生
     */
    @GetMapping("/findAll")
    public List<Kc> findAll() {

        return kcService.findAll();
    }

    /**
     * 增加学生
     */
    @PostMapping("/addKc")
    public void addStudent(@RequestBody Kc kc) {

        kcService.addKc(kc);
    }

    /**
     * 根据学生id删除学生
     */
    @PostMapping("/deleteKc")
    public void deleteKc(@RequestParam Integer id) {
        this.kcService.deleteKc(id);
    }

    /**
     * 编辑学生
     */
    @PostMapping("/updateKc")
    public void updateStudent(@RequestBody Kc kc) {

        this.kcService.updateKc(kc);
    }

    /**
     * 根据学生姓名查找学生
     */
    @GetMapping("/findKcByName")
    public List<Kc> findStudentByName(@RequestParam String kcname) {
        return this.kcService.findKcByName(kcname);
    }

    /**
     * 批量删除课程
     */
    @PostMapping("/deleteKcs")
    public Integer deleteKcs(Integer[] ids) {
        return this.kcService.deleteKcs(ids);
    }
}
