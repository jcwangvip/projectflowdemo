package com.jc.integrated.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 索引为blog,类型为blog
 *
 * @author jiancheng
 * @date 2020-1-3
 */
@Data
@NoArgsConstructor
@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {

    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    public EsBlog(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public EsBlog(String id, String title, String summary, String content) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
    }
}
