package com.javapractice.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


import java.util.HashMap;
import java.util.Map;

public class Result<T> {

    public static String success(Object object) {

        String str = "{}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "200");
        map.put("message", "成功");
        map.put("data", object);

        try {
            str = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue);
        } catch (Exception e) {
//            log.error(e.getMessage());
        }

        return str;
    }

    public static Map<String, Object> successMap(Object object) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "200");
        map.put("message", "成功");
        map.put("data", object);

        return map;
    }

    public static String success(String msg) {

        String str = "{}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "200");
        map.put("message", msg);
        try {
            str = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue);
        } catch (Exception e) {
//            log.error(e.getMessage());
        }
        return str;
    }

    public static String fail(String message) {

        String str = "{}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "600");
        map.put("message", message);
        map.put("data", null);

        try {
            str = JSONObject.toJSONString(map);
        } catch (Exception e) {
//            log.error(e.getMessage());
        }

        return str;
    }

    public static Map<String, Object> failForBcms(String message) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "600");
        map.put("message", message);
        map.put("data", null);
        return map;
    }

    public static String success(String message, Object data) {

        String str = "{}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "200");
        map.put("message", message);
        map.put("data", data);

        try {
            str = JSONObject.toJSONString(map);
        } catch (Exception e) {
//            log.error(e.getMessage());
        }

        return str;
    }

    public static String fail(String message, int code) {

        String str = "{}";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);

        try {
            str = JSONObject.toJSONString(map);
        } catch (Exception e) {
//            log.error(e.getMessage());
        }

        return str;
    }
}
