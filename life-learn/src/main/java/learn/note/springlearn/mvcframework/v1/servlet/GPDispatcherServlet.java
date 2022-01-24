package learn.note.springlearn.mvcframework.v1.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GPDispatcherServlet
 * @Author wwl
 * @Date 2021/7/24 16:50
 * @Version 1.0
 **/
public class GPDispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 6067723019705999943L;

    private Map<String,Object> mapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
