package com.pbj.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PBJ
 * @since 2020-08-31
 */
@RestController
@RequestMapping("/edu-examqucont")
public class EduExamqucontController {

    @GetMapping("sync/{name}")
    public String sync(@PathVariable("name") String name){
        return "你好"+name;
    }

}

