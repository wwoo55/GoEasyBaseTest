package com.example.servlet;

import com.example.domain.Consumer;
import com.example.domain.QueryVo;
import com.example.service.TestService;
import com.example.service.impl.TestServiceImpl;
import com.example.util.DateUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

/**
 * @projectName: demo_xy
 * @className: TestServlet
 * @description:
 * @author: xy
 * @time: 2021/3/26 14:13
 */
@WebServlet("/test/*")
public class TestServlet extends BaseServlet {

    /**
     * 添加新顾客
     * @param request
     * @param response
     * @throws IOException
     * @throws ParseException
     */
    public void insertClient(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        request.setCharacterEncoding("UTF-8");
        // 1.获取参数
        String nameStr = request.getParameter("name");
        String sexStr = request.getParameter("sex");
        String birthdateStr = request.getParameter("birthdate");
        String telStr = request.getParameter("tel");
        String jobStr = request.getParameter("job");
        String noteStr = request.getParameter("note");

        // 2.参数处理并封装为对象
        Consumer consumer = new Consumer();
        consumer.setName(nameStr);
        consumer.setSex("male".equals(sexStr) ? 1 : 2);
        consumer.setBirthdate(DateUtils.convertDate(birthdateStr));
        consumer.setTel(telStr);
        consumer.setJob(jobStr);
        consumer.setNote(noteStr);
        System.out.println(consumer);

        // 3.调用service
        TestService testService = new TestServiceImpl();
        testService.insert(consumer);

        // 4.返回结果
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "success" + "</h1>");
        out.println("<a href=\"../add.jsp\">" + "继续添加" + "</a>");
        out.println("<a href=\"../query.jsp\">" + "不添加了，开始查询" + "</a>");
        out.println("</body></html>");

    }

    /**
     * 查询已添加顾客
     * @param request
     * @param response
     * @throws IOException
     * @throws ParseException
     */
    public void queryClient(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        request.setCharacterEncoding("UTF-8");
        // 1.获取参数
        String nameStr = request.getParameter("name");
        String sexStr = request.getParameter("sex");
        String birthdateStr = request.getParameter("birthdate");


        // 2.参数处理并封装为对象
        QueryVo queryVo = new QueryVo();
        if (!nameStr.isEmpty()){
            queryVo.setName(nameStr);
        }

        if (sexStr!=null){
            queryVo.setSex("male".equals(sexStr) ? 1 : 2);
        }

        if (!birthdateStr.isEmpty()) {
            queryVo.setBirthdate(DateUtils.convertDate(birthdateStr));
        }

        // 3.调用service
        TestService testService = new TestServiceImpl();
        List<Consumer> consumers = testService.search(queryVo);

        // 4.返回结果
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "result" + "</h1>");
        for (Consumer consumer : consumers) {
            out.println("<h1>" + consumer + "</h1>");
        }
        out.println("<a href=\"../query.jsp\">" + "继续查询" + "</a>");
        out.println("<a href=\"../add.jsp\">" + "不查询了，开始添加" + "</a>");
        out.println("</body></html>");
    }
}
