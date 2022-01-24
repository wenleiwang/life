package learn.note.springlearn.bean.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 响应体中包含单个数据
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
public class ResponseDataBase<T> extends ResponseBase implements Serializable {
    private static final long serialVersionUID = -6413706589728186439L;

    @ApiModelProperty(value = "单个数据实体")
    @JsonProperty("Data")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
