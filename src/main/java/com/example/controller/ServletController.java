package com.example.controller;

import com.example.dto.InsurancePolicyDTO;
import com.example.service.IPolicyService;
import com.example.service.PolicyServiceImpl;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/controller", loadOnStartup = 1)
public class ServletController extends HttpServlet {

    private IPolicyService service = null;

    public void init() {
        service = new PolicyServiceImpl();
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int pageNo = 0;
        //total num of records in each page
        int pageSize = 0;
        //Total number of pages
        long pageCount = 0;
        List<InsurancePolicyDTO> listDto = null;
        String targetPage = null;
        RequestDispatcher rd = null;
        HttpSession httpSession = null;
        String value = request.getParameter("s1");
        System.out.println(value);
        httpSession = request.getSession(true);
        if (value.equals("generateReport")) {
            pageNo = 1;
            //gets value from user input
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if (httpSession != null)
                httpSession.setAttribute("pageSize", pageSize);
        } else {
            //Gets value from hyperlinks
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if (httpSession != null)
                pageSize = (int) httpSession.getAttribute("pageSize");
        }
        try {
            listDto = service.fetchPageData(pageSize, pageNo);
            pageCount = service.fetchPagesCount(pageSize);

            //Values will come from service  layer depending on user input
            request.setAttribute("policyList", listDto);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("pageNo", pageNo);
            targetPage = "./display.jsp";
        } catch (HibernateException he) {
            he.printStackTrace();
            targetPage = "./error.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            targetPage = "./error.jsp";
        }
        rd = request.getRequestDispatcher(targetPage);
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            processRequest(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            processRequest(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        service = null;
        HibernateUtil.closeSessionFactory();
    }
}