package com.pbj.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbj.mapper.EduExamquMapper;
import com.pbj.mapper.EduExamqucontMapper;
import com.pbj.pojo.EduExamqu;
import com.pbj.pojo.EduExamqucont;
import com.pbj.repository.EduExamquRepository;
import com.pbj.service.EduExamquService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

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

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<EduExamqu> sync() {
        QueryWrapper<EduExamqu> queryWrapper=new QueryWrapper<>();
        System.out.println(eduExamquMapper.getClass());
        queryWrapper.eq("gradeId",10);
        queryWrapper.eq("subId",11);
//        queryWrapper.eq("id","20488");
        List<EduExamqu> eduExamqus = eduExamquMapper.selectList(queryWrapper);
        eduExamqus.forEach(item->{
            QueryWrapper<EduExamqucont> query=new QueryWrapper<EduExamqucont>();

            query.eq("quId",item.getId());
            List<EduExamqucont> eduExamquconts = eduExamqucontMapper.selectList(query);
            item.setEduExamqucontList(eduExamquconts);
            EduExamqu save = eduExamquRepository.save(item);
        });
        return eduExamqus;
    }

    @Override
    public List<EduExamqu> setHigh(String keyword) {
        /*查询设置*/
        BoolQueryBuilder queryBuilder= QueryBuilders.boolQuery();
        queryBuilder
                .should(QueryBuilders.matchQuery("material",keyword));
//                .should(QueryBuilders.matchQuery("unitId",keyword))
//                .should(QueryBuilders.matchQuery("knowledgeCodes",keyword));
        /*高亮设置*/
        String preTag = "<font color='#dd4b39'>";//google的色值
        String postTag = "</font>";
        HighlightBuilder highlightBuilder=new HighlightBuilder();
        highlightBuilder
                .preTags(preTag)
                .postTags(postTag)
                .field("material")
                .field("unitId")
                .field("knowledgeCodes");
        //searchQueryBuilder 可以将多个条件组合在一起
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        //高亮显示
        searchQueryBuilder.withHighlightBuilder(highlightBuilder);
        //分页显示
        searchQueryBuilder.withPageable( PageRequest.of(0, 10000));
        //查询条件
        searchQueryBuilder.withQuery(queryBuilder);
        //排序条件
        //searchQueryBuilder.withSort()
        AggregatedPage<EduExamqu> eduExamqus = elasticsearchTemplate.queryForPage(searchQueryBuilder.build(), EduExamqu.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                /*定义一个容器把数据装起来*/
                List<EduExamqu> examquList = new ArrayList<>();
                //我们所有查询的结果都放在这个searchResponse里面
                //我们现在就是要把我们想要的内容从这个searchResponse里面获取到
                SearchHits hits = searchResponse.getHits();
                //如果getTotalHits是0 则表示查询不到数据
                if (hits.getTotalHits() <= 0) {
                    return null;
                } else {
                    //从里面获取到一条一条的数据了
                    for (SearchHit hit : hits) {
                        Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                        EduExamqu examqu = BeanUtil.fillBeanWithMap(sourceAsMap, new EduExamqu(), false);
                        //还要获取到某个字段的高亮特征 高亮的特征和当前的数据 做一个替换
                        HighlightField materialHighlight = hit.getHighlightFields().get("material");
                        if (materialHighlight != null) {
                            examqu.setMaterial(materialHighlight.fragments()[0].toString());
                        } else {
                            String material = (String) hit.getSourceAsMap().get("material");
                            examqu.setMaterial(material);
                        }
                        //还要获取到某个字段的高亮特征 高亮的特征和当前的数据 做一个替换
                        HighlightField unitIdHighlight = hit.getHighlightFields().get("unitId");
                        if (unitIdHighlight != null) {
                            examqu.setUnitId(unitIdHighlight.fragments()[0].toString());
                        } else {
                            String unitId = (String) hit.getSourceAsMap().get("unitId");
                            examqu.setUnitId(unitId);
                        }
                        //还要获取到某个字段的高亮特征 高亮的特征和当前的数据 做一个替换
                        HighlightField knowledgeCodesHighlight = hit.getHighlightFields().get("knowledgeCodes");
                        if (knowledgeCodesHighlight != null) {
                            examqu.setKnowledgeCodes(knowledgeCodesHighlight.fragments()[0].toString());
                        } else {
                            String knowledgeCodes = (String) hit.getSourceAsMap().get("knowledgeCodes");
                            examqu.setKnowledgeCodes(knowledgeCodes);
                        }
                        examquList.add(examqu);
                    }
                }
                return new AggregatedPageImpl(examquList);
            }
            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                return null;
            }
        });
        List<EduExamqu> examquList = eduExamqus.toList();
        return examquList;
    }
}












//            query.select("id","cont","prepA","prepB","prepC",
//                    "prepD",
//                    "prepE",
//                    "prepF",
//                    "prepG",
//                    "prepH",
//                    "quId",
//                    "picId",
//                    "isAuto",
//                    "errNum",
//                    "trueFreq",
//                    "useNum",
//                    "errFreq",
//                    "anspicId",
//                    "prepApicId",
//                    "prepBpicId",
//                    "prepCpicId",
//                    "prepDpicId",
//                    "prepEpicId",
//                    "prepFpicId",
//                    "prepGpicId",
//                    "prepHpicId",
//                    "keyPointCode",
//                    "typeId",
//                    "syncType",
//                    "ansImageWidth",
//                    "analysisImageWidth"
//                    );
