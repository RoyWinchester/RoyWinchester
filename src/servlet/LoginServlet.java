package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import util.DBManager;
import util.Convert;
import java.sql.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名、密码与验证码
        String userid=Convert.toChinese(request.getParameter("username"));
        String userpass=Convert.toChinese(request.getParameter("password"));
        String useryzm=request.getParameter("txtCode");
        //获取Session中的验证码
        HttpSession session = request.getSession() ;
        String YZM=(String) session.getAttribute("yzm") ;
        //检查验证码是否正确
        if(!useryzm.equals(YZM)){
            //验证码错误，登录失败。
            response.sendRedirect("../lottery/loginError.jsp?st=1");

        }else{
            //连接数据库，根据用户信息表进行用户验证。
            String sql="select * FROM admin where adminid='"+userid+"' and password='"+userpass+"';";
            try {
                Connection conn=DBManager.getConnection();
                Statement stmt= conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next()){
                    //登录成功；在session中设置已登录标志。
                    session.setAttribute("isLogin", true);
                    session.setAttribute("userid", userid);
//                    if(rs.getInt("type")==1){
//                        response.sendRedirect("../index.jsp");
//                    }else{
//                        response.sendRedirect("../index.jsp");
//                    }
                    response.sendRedirect("../lottery/admin.jsp");
                }else{
                    //用户名或密码错误，登录失败。
                    response.sendRedirect("../lottery/loginError.jsp?st=2");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("../lottery/loginError.jsp?st=0");
            }
        }
    }
}
