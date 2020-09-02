package com.pbj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pbj.pojo.EduExamqu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PBJ
 * @since 2020-08-31
 */
public interface EduExamquService extends IService<EduExamqu> {

    public List<EduExamqu> sync();

    List<EduExamqu> setHigh(String keyword);
}
