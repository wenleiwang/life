package learn.controller;

import learn.designpatterns.strategypattern.FormSubmitHandler;
import learn.designpatterns.strategypattern.FormSubmitHandlerFactory;
import learn.designpatterns.strategypattern.FormSubmitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author WangWenLei
 * @DATE: 2021/7/21
 **/
@RestController
public class Test {
    @Autowired
    FormSubmitHandlerFactory formSubmitHandlerFactory;
    @GetMapping("/test")
    public String test(){
        FormSubmitRequest request = new FormSubmitRequest();
        request.setSubmitType("model");
        request.setUserId(10086L);
        request.setFormInput(new HashMap<>());
        FormSubmitHandler<Serializable> model = formSubmitHandlerFactory.gethandler(request.getSubmitType());
        model.handleSubmit(request);
        return  "成功过！";
    }
}
