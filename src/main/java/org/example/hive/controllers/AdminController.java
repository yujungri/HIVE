package org.example.hive.controllers;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Controller
public class AdminController {
    @Autowired
    AdminService service;

    @Value("#{servletContext.contextPath}")
    String contextPath;

    /** index 페이지(아직 미정) */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpServletResponse response) {
        return "Join";
    }

    /** 회원가입 작성 폼 페이지 */
    @RequestMapping(value = "/Join.do", method = RequestMethod.GET)
    public String add(Model model, HttpServletResponse response) {
        return "Join";
    }

    /** 작성 폼에 대한 action 페이지 */
    @RequestMapping(value = "/Join_ok.do", method = RequestMethod.POST)
    public void addOk(Model model, HttpServletResponse response,
                      @RequestParam(value="password") String password,
                      @RequestParam(value="email") String email,
                      @RequestParam(value="name") String name,
                      @RequestParam(value="contact") String contact,
                      @RequestParam(value="department_cd") String department_cd ) {

        // 저장할 값들을 Beans에 담는다.
        Admin input = new Admin();
        input.setPassword(password);
        input.setEmail(email);
        input.setName(name);
        input.setContact(contact);
        input.setDepartment_cd(department_cd);

        switch(department_cd){
            case "A":
                input.setDepartment_nm("관리자");
                break;
            case "C":
                input.setDepartment_nm("콘텐츠관리팀");
                break;
            case "I" :
                input.setDepartment_nm("인사팀");
                break;
        }

        try {
            // 데이터 저장 --> 데이터 저장에 성공하면 파라미터로 전달하는 input 객체에 PK값이 저장된다.
            service.addAdmin(input);
        } catch (Exception e) { e.printStackTrace(); }

        try {
            response.sendRedirect(contextPath + "/Join.do");
        } catch (IOException e) { e.printStackTrace(); }

    }
}

