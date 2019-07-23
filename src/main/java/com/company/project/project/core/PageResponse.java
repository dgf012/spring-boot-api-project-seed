package com.company.project.project.core;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@ApiModel
public class PageResponse<E> {

    @ApiModelProperty("页码")
    protected int pageNum;
    @ApiModelProperty("总记录数")
    protected long total;
    @ApiModelProperty("记录列表")
    protected List<E> list;

    /**
     * 生成Page
     *
     * @param pageInfo
     * @param <E>
     * @return
     */
    public static <E> PageResponse<E> getPage(PageInfo<E> pageInfo) {
        PageResponse<E> page = new PageResponse<>();
        page.setPageNum(pageInfo.getPageNum());
        page.setTotal(pageInfo.getTotal());
        page.setList(pageInfo.getList());
        return page;
    }
}
