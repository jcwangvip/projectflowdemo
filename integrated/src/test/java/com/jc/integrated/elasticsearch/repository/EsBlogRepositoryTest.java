package com.jc.integrated.elasticsearch.repository;

import com.jc.integrated.elasticsearch.dto.BlogDTO;
import com.jc.integrated.elasticsearch.entity.EsBlog;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Optional;

/**
 * es基本的CRUD
 *
 * @author jiancheng
 * @date 2020-1-3
 */
@Slf4j
@SpringBootTest
class EsBlogRepositoryTest {


    @Autowired
    private EsBlogRepository esBlogRepository;


    @Test
    public void page() {
        BlogDTO blogDTO = getQueryDTO();
        QueryBuilder queryBuilder = EsBlogRepository.getQueryBuilder(blogDTO);
        log.info("查询条件:{}", queryBuilder);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Iterable<EsBlog> search = esBlogRepository.search(queryBuilder, PageRequest.of(blogDTO.pageIndex - 1, blogDTO.pageSize, sort));
    }


    private BlogDTO getQueryDTO() {
        BlogDTO blogDTO = new BlogDTO();
//        blogDTO.setIds(Arrays.asList("1"));
        return blogDTO;
    }

    @Test
    void findAll() {
        Iterable<EsBlog> all = esBlogRepository.findAll();
        for (EsBlog anAll : all) {
            log.info("开始输出:{}", anAll);
        }
    }

    @Test
    void findById() {
        Optional<EsBlog> byId = esBlogRepository.findById("1");
        if (!byId.isPresent()) {
            log.info("没有找到");
            return;
        }
        log.info("输出结果{}", byId.get());
    }

    @Test
    void update() {
        String id = "1";
        Optional<EsBlog> esBlogOptional = esBlogRepository.findById(id);
        if (!esBlogOptional.isPresent()) {
            log.info("修改的id没有找到");
            return;
        }
        EsBlog blog = esBlogOptional.get();
        log.info("修改前:{}", blog);
        blog.setSummary("修改");
        esBlogRepository.save(blog);
        esBlogRepository.findById(id).ifPresent(x -> log.info("修改后:{}", x));
    }

    @Test
    void save() {
        EsBlog blog = new EsBlog("1", "elastucsearch学习");
        esBlogRepository.save(blog);
    }

    @Test
    void saveNotId() {
        EsBlog blog = new EsBlog();
        blog.setContent("测试elastucsearch不带id保存");
        EsBlog save = esBlogRepository.save(blog);
        log.info("保存完毕{}", save);
    }

}
