package com.javapractice.controller;

import com.javapractice.aop.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="api/ApiDemo/")
public class ApiDemoController {

    @Autowired
    private GreetingService svc;

    @GetMapping(value = "studentListGet")
    public Map<String, Object> queryStudentListGet(@RequestParam Long classId) {

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

            String result = svc.hello("Java");
            System.out.println("result = " + result);

        // クラスに学生をセット
        classBean.setStudentBeanList(students);
        return Result.successMap(classBean);
    }

    @GetMapping(value = "{classId}/studentListGet1")
    public String queryStudentListGet1(@PathVariable("classId") Long classId) {

        System.out.printf("classId="+classId);

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

        Map<Long, ClassManagementBean> classMap = new HashMap<>();
        classMap.put(classBean.getId(), classBean);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("class", classBean);
        resultMap.put("studentList", students);
        // クラスに学生をセット
//        classBean.setStudentBeanList(students);
        return Result.success(resultMap);
    }

    @PostMapping(value = "studentListPost")
    public String queryStudentListPost(@RequestBody ClassInfo classInfo) {

        System.out.printf("ーーー＞classId="+classInfo.getClassId());

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
