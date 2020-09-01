package com.pbj.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbj.mapper.EduExamquMapper;
import com.pbj.mapper.EduExamqucontMapper;
import com.pbj.pojo.EduExamqu;
import com.pbj.pojo.EduExamqucont;
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

    @Autowired
    private EduExamqucontMapper eduExamqucontMapper;

    @Override
    public List<EduExamqu> sync() {
        QueryWrapper<EduExamqu> queryWrapper=new QueryWrapper<>();
        System.out.println(eduExamquMapper.getClass());
        queryWrapper.eq("gradeId",10);
        queryWrapper.eq("subId",13);
//        queryWrapper.eq("id","20488");
        List<EduExamqu> eduExamqus = eduExamquMapper.selectList(queryWrapper);
        eduExamqus.forEach(item->{
            QueryWrapper<EduExamqucont> query=new QueryWrapper<EduExamqucont>();
            query.select("id","cont","prepA","prepB","prepC",
                    "prepD",
                    "prepE",
                    "prepF",
                    "prepG",
                    "prepH",
                    "quId",
                    "picId",
                    "isAuto",
                    "errNum",
                    "trueFreq",
                    "useNum",
                    "errFreq",
                    "anspicId",
                    "prepApicId",
                    "prepBpicId",
                    "prepCpicId",
                    "prepDpicId",
                    "prepEpicId",
                    "prepFpicId",
                    "prepGpicId",
                    "prepHpicId",
                    "keyPointCode",
                    "typeId",
                    "syncType",
                    "ansImageWidth",
                    "analysisImageWidth"
                    );
            query.eq("quId",item.getId());
            List<EduExamqucont> eduExamquconts = eduExamqucontMapper.selectList(query);
            item.setEduExamqucontList(eduExamquconts);
            EduExamqu save = eduExamquRepository.save(item);
        });
        return eduExamqus;
    }
}
