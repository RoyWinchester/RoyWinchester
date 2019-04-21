package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import model.Roll;
import service.RollJsonService;
import java.io.PrintWriter;



@WebServlet(name = "RollServlet")
public class RollServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求发送都是utf-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        //查询用户信息
        List<Roll> list = new RollJsonService().finall();
        //封装好的用户信息放到json中返回前台
        String json = null;
        json = JSON.toJSONString(list);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(json);
        out.print(json);

    }
}
