package org.neuedu.controller.classteam;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.neuedu.bean.RespBean;
import org.neuedu.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddClassTeamServlet",value = "/addClass")
public class AddClassTeamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        String type = request.getParameter("type");
        String tid = request.getParameter("tid");
        ClassService service = new ClassService();
        RespBean respBean = service.addClass(cname,type,tid);
        response.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
