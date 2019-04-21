package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.alibaba.fastjson.JSON;
import dao.CandidateDao;
import model.Candidate;
import util.Convert;

@WebServlet(name = "CandidateServlet")
public class CandidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CandidateDao candidateDao=new CandidateDao();
        List<Candidate> candidateList;
        candidateList=candidateDao.pickCandidate();
        String json = null;
        json = JSON.toJSONString(candidateList);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}
