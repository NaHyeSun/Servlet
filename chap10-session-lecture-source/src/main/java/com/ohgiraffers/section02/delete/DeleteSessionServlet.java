package com.ohgiraffers.section02.delete;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());

        }

        /* [ 세션 데이터를 지우는 방법 ]
         *  1. 설정한 만료 시간이 지나면 세션이 만료된다.
         *  2. removeAttribute()로 session의 Attribute를 지운다.
         *  3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.
         *  */

        System.out.println("--------------------------------------");
        session.removeAttribute("finstName");

        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());

            System.out.println("----------------------------------");
            session.invalidate();

            sessionNames = session.getAttributeNames();
            while (sessionNames.hasMoreElements()) {
                System.out.println(sessionNames.nextElement());

            }
        }
    }
}
