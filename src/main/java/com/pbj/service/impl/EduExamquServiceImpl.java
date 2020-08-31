package com.pbj.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbj.mapper.EduExamquMapper;
import com.pbj.pojo.EduExamqu;
import com.pbj.repository.EduExamquRepository;
import com.pbj.service.EduExamquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PBJ
 * @since 2020-08-31
 */
@Service
public class EduExamquServiceImpl extends ServiceImpl<EduExamquMapper, EduExamqu> implements EduExamquService {

    @Autowired
    private EduExamquMapper eduExamquMapper;

    @Autowired
    private EduExamquRepository eduExamquRepository;

    @Override
    public List<EduExamqu> sync() {
        QueryWrapper<EduExamqu> queryWrapper=new QueryWrapper<>();
        System.out.println(eduExamquMapper.getClass());
        queryWrapper.eq("id",20488);
        List<EduExamqu> eduExamqus = eduExamquMapper.selectList(queryWrapper);
        eduExamquRepository.saveAll(eduExamqus);
        return eduExamqus;
    }
}
