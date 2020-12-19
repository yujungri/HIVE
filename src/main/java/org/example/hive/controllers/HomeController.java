package org.example.hive.controllers;

import org.example.hive.model.Admin;
import org.example.hive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {
    @Autowired
    AdminService service;

    @Value("#{servletContext.contextPath}")
    String contextPath;

    /** 작성 폼 페이지 */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpServletResponse response) {
        return "SignUp";
    }

    @RequestMapping(value = "/SignUp.do", method = RequestMethod.GET)
    public String add(Model model, HttpServletResponse response) {
        return "SignUp";
    }

    /** 작성 폼에 대한 action 페이지 */
    @RequestMapping(value = "/SignUp_ok.do", method = RequestMethod.POST)
    public void addOk(Model model, HttpServletResponse response,
                      @RequestParam(value="name") String name,
                      @RequestParam(value="email") String email) {

        // 저장할 값들을 Beans에 담는다.
        Admin input = new Admin();
        input.setName(name);
        input.setEmail(email);

        try {
            // 데이터 저장 --> 데이터 저장에 성공하면 파라미터로 전달하는 input 객체에 PK값이 저장된다.
            service.signUp(input);
        } catch (Exception e) { e.printStackTrace(); }

        try {
            response.sendRedirect(contextPath + "/SignUp.do");
        } catch (IOException e) { e.printStackTrace(); }

    }
}

