package com.xs.cloud.common.common.service.impl;

import com.xs.cloud.common.common.mapper.UserMapper;
import com.xs.cloud.common.common.pojo.EsUserResponse;
import com.xs.cloud.common.common.service.UserService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<Map> testCity() {
        List<Map> maps =    userMapper.testCity();

        return maps;
    }

    @Override
    public List<EsUserResponse> esSelectUser() {
        /**
         * 合并查询 BoolQueryBuilder
         * （是searchQuery 的子集相当于，可以合并，在此提取出来做了个判断）
         *     即boolQuery，可以设置多个条件的查询方式。它的作用是用来组合多个Query，
         *     有四种方式来组合，must（必须），mustnot（必须不），filter（对查询结果缓存，与must类型），should（应该）
         */
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

       /* if(goodSBean.getName()!=null &&!"".equals(goodSBean.getName())){
            boolQueryBuilder.filter(QueryBuilders.queryStringQuery(goodSBean.getName()));
        }
        if (goodSBean.getStartPrice()!=null &&!"".equals(goodSBean.getStartPrice())){
            //范围查询（range query）gte 大于等于
            boolQueryBuilder.filter(QueryBuilders.rangeQuery("pc_price").gt(goodSBean.getStartPrice()).lt(goodSBean.getEndPrice()));
        }*/
        Integer page=1;
        Integer rows=100;

        //定义条查加分页 构建查询条件
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withHighlightFields(new HighlightBuilder.Field("ad_title").highlightFilter(true))
                .withQuery(boolQueryBuilder).build();
     /*   if (goodSBean.getAsc()!=null){
            Sort sort1 = new Sort(Sort.Direction.ASC,"pc_price");
            Sort sort2 = new Sort(Sort.Direction.DESC,"pc_price");
            if (goodSBean.getAsc()==1) {
                searchQuery.addSort(sort1);
            }
            if (goodSBean.getAsc()==2) {
                searchQuery.addSort(sort2);
            }
        }*/
        List<EsUserResponse> goodSBeans = elasticsearchTemplate.queryForList(searchQuery, EsUserResponse.class);
/*        Long count=elasticsearchTemplate.count(searchQuery);
        Map<String , Object> result = new HashMap<>();
        result.put("total",count);
        result.put("rows",goodSBeans);*/
        return goodSBeans;
    }


}
