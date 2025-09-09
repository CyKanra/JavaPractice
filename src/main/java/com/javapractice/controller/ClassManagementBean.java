package com.javapractice.controller;

import lombok.Data;

import java.util.List;

@Data
public class ClassManagementBean {

    private Long id;

    private String className;

    private List<StudentBean> studentBeanList;
}
