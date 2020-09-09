package com.jc.integrated.elasticsearch.repository;

import com.jc.integrated.elasticsearch.dto.BlogDTO;
import com.jc.integrated.elasticsearch.entity.EsBlog;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2020-1-3
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    static QueryBuilder getQueryBuilder(BlogDTO blogDTO) {
        BoolQueryBuilder last = QueryBuilders.boolQuery();
        if (!CollectionUtils.isEmpty(blogDTO.getIds())) {
            last.must(QueryBuilders.termQuery("id", blogDTO.getIds()));
        }
        if (!StringUtils.isEmpty(blogDTO.getTitle())) {
            last.must(QueryBuilders.termQuery("title", blogDTO.getTitle()));
        }
        return last;
    }
}
