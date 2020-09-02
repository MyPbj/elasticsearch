package com.pbj.controller;


import com.pbj.pojo.EduExamqu;
import com.pbj.service.EduExamquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PBJ
 * @since 2020-08-31
 */
@RestController
@RequestMapping("/edu-examqu")
public class EduExamquController {

    @Autowired
    private EduExamquService eduExamquService;

    @GetMapping("/sync")
    public String sync(){
        eduExamquService.sync();
        return "";
    }

    @GetMapping("getEduExamqu/{param}")
    public List<EduExamqu> getEduExamqu(@PathVariable("param")String param){
        List<EduExamqu> examquList = eduExamquService.setHigh(param);
        return examquList;
    }
}

