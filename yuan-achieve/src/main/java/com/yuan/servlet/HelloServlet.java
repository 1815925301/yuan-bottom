package com.yuan.servlet;

import com.yuan.utils.DateTimeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * FileName: HelloServlet
 * Author:   yhl
 * Date:     2018/11/17 21:52
 * Description: ${DESCRIPTION}
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String createTime = DateTimeUtils.getNowTime();
        req.setAttribute("createTime1",111);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    private String aa;
    private String aa4;
}
