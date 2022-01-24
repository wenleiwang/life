package learn.note.springlearn.bean.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
public class ResponseBase implements Serializable {
    private static final long serialVersionUID = 7519115260456739260L;

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    @ApiModelProperty(value = "结果状态 1-成功；0-失败")
    @JsonProperty("Result")
    private int result;

    @ApiModelProperty(value = "说明信息")
    @JsonProperty("Message")//把该属性的名称序列化为另外一个名称
    private String message;


    public int getResult() {
        return result;
    }

    public ResponseBase setResult(int result) {
        this.result = result;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseBase setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseBase successful(){
        this.setResult(1).setMessage(DEFAULT_SUCCESS_MESSAGE);
        return this;
    }

    public ResponseBase successful(String sucMsg){
        this.setResult(1).setMessage(sucMsg);
        return this;
    }

    public ResponseBase fail(){
        this.setResult(0).setMessage(DEFAULT_FAIL_MESSAGE);
        return this;
    }

    public ResponseBase fail(String errorMsg){
        this.setResult(0).setMessage(errorMsg);
        return this;
    }
}
