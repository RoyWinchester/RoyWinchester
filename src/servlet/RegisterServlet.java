package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.Convert;
import util.DBManager;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=Convert.toChinese(request.getParameter("username"));
        String userpass=Convert.toChinese(request.getParameter("password"));
        try{
            Connection conn=DBManager.getConnection();
            Statement stmt= conn.createStatement();
            String sql="select * FROM admin where adminid='"+userid+"';";
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                response.sendRedirect("../lottery/registerError.jsp?st=1");
            }else {
                sql="insert into admin(adminid,password)";
                sql=sql+" value('"+userid+"','"+userpass+"')";
                int cnt=stmt.executeUpdate(sql); //执行SQL语句，向数据库添加用户
                if (cnt>0){
                    //注册成功；在session中设置已登录标志。
                    HttpSession session = request.getSession() ;
                    session.setAttribute("userid", userid);
                    response.sendRedirect("../lottery/login.jsp");//重定向到主页
                }
                else{
                    //注册失败。
                    response.sendRedirect("../lottery/registerError.jsp?st=2");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            response.sendRedirect("../lottery/registerError.jsp?st=3");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
