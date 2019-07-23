package com.company.project.project.core;

import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class PageRequest {
    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNum;

    @ApiModelProperty(value = "每页数量", example = "20")
    private Integer pageSize;

    public Integer getPageNum() {
        return (pageNum == null || pageNum <= 0) ? 1 : pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            return defaultPageSize();
        } else {
            return pageSize;
        }
    }

    protected Integer defaultPageSize() {
        return ProjectConstant.WEB_PAGE_SIZE_DEFAULT;
    }
}
