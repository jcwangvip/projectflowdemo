package com.jc.integrated.elasticsearch.dto;

import lombok.Data;

import java.util.List;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2020-1-3
 */
@Data
public class BlogDTO {
    public int pageIndex = 1;
    public int pageSize = 10;

    private List<String> ids;
    private String title;
    private String summary;
    private String content;

}
