package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    //1. /cars/sell;low=34;brand=byd,audi,yd
    //2. springboot默认禁用了 矩阵变量的功能
    //        手动开启：原理。对于路径的处理。UrlPathHelper的removeSemicolonContent设置为false，让其支持矩阵变量的。
    @GetMapping("/cars/{path}")
    public Map carsSell(
            @MatrixVariable("low")Integer low,
            @MatrixVariable("brand")List<String> brand,
            @PathVariable("path")String path

    ){
        Map<String,Object> map=new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path",path );
//        map.put("", );
        return map;
    }


    //1. /boos/1;age=10/2;age=20
    @GetMapping("/boos/{bossId}/{empId}")
    public Map boos(
            @MatrixVariable(pathVar = "boosId",value = "age")Integer bossAge
            , @MatrixVariable(pathVar = "empId",value = "age")Integer empAge
            , @PathVariable("boosId")String path1
            , @PathVariable("empId")String path2
    ){
        Map<String,Object> map=new HashMap<>();
        map.put("bossAge",bossAge );
        map.put("empAge",empAge );
        map.put("path1",path1 );
        map.put("path2",path2 );
        return map;
    }






    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id ,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,String> pv,

                                     @RequestHeader("User-Agent")String userAgent,
                                     @RequestHeader Map<String,String> header,

                                     @RequestParam("age")Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params
                                     ){
        Map<String,Object> map=new HashMap<>();
//        map.put("id",id);
//        map.put("username",username);
//        map.put("pv",pv);
//
//        map.put("userAgent",userAgent);
//        map.put("headers",header);

        map.put("age",age );
        map.put("inters",inters );
        map.put("params",params );
//        map.put("", );
//        map.put("", );
//        map.put("", );
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
}
