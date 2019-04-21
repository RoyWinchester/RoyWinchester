package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Random;


@WebServlet(name = "CreateYZMServlet")
public class CreateYZMServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置输出MIME类型为JPEG图片
        response.setContentType("image/jpeg") ;
        /*设置浏览器不保存缓存，避免用户刷新页面时验证码图片不更新，
         * 造成用户看到的验证码与系统中的验证码不一致。
         */
        response.setHeader("Cache-Control", "no-cache") ;
        //创建验证码图片对象
        int width = 70,height = 20 ;
        BufferedImage image = new
                BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
        Graphics g = image.getGraphics() ;
        //生成5位整数随机数验证码
        Random random = new Random() ;
        String yzm = "" ;
        for(int i=0;i<5;i++){
            yzm += random.nextInt(10) ;
        }
        //把验证码存到Session里面，用于与用户输入的验证码进行比较。
        HttpSession session = request.getSession() ;
        session.setAttribute("yzm",yzm) ;
        //设置验证码图片背景为白色
        g.setColor(new Color(51,153,255)) ;
        g.fillRect(0, 0, 90, 22);
        //把验证码写到图片上
        g.setColor(new Color(200,200,200)) ;
        Font font = new Font(null,Font.ITALIC,18) ;
        g.setFont(font);
        g.drawString(yzm,7,height) ;
        g.dispose() ;
        //把图片输出到客户端浏览器；PrintWriter操作的是字符流，在这里不能使用 。
        ServletOutputStream output = response.getOutputStream() ;
        ImageIO.write(image,"JPEG",output) ;
        output.flush();
    }
}
