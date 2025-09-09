package com.javapractice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="api/ApiDemo/",produces="application/json;charset=utf-8")
public class ApiDemoController {

    @GetMapping(value = "studentList")
    public String queryAbleAppointmentCourseList(@RequestParam Long classId) {

        System.out.printf("classId"+classId);

        // クラス情報
        ClassManagementBean classBean = new ClassManagementBean();
        classBean.setId(1L);
        classBean.setClassName("情報処理クラス");

        // 学生リスト
        List<StudentBean> students = new ArrayList<>();

        StudentBean s1 = new StudentBean();
        s1.setId(101L);
        s1.setClassId("1");
        s1.setName("佐藤太郎");
        s1.setSex("男");
        s1.setAge("20");

        StudentBean s2 = new StudentBean();
        s2.setId(102L);
        s2.setClassId("1");
        s2.setName("鈴木花子");
        s2.setSex("女");
        s2.setAge("21");

        StudentBean s3 = new StudentBean();
        s3.setId(103L);
        s3.setClassId("1");
        s3.setName("田中健");
        s3.setSex("男");
        s3.setAge("19");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        // クラスに学生をセット
        classBean.setStudentBeanList(students);
        return Result.success(classBean);
    }
}
