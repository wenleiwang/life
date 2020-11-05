package com.wenwen.blog.util.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
public class ResponseListBase<T> extends ResponseBase implements Serializable {
    private static final long serialVersionUID = -5747842555868494581L;

    @ApiModelProperty(value = "列表数据实体")
    @JsonProperty("Data")
    private List<T> data;

    @ApiModelProperty(value = "数据总数，用于分页")
    @JsonProperty("TotalCount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int totalCount;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
