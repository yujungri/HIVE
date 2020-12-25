package org.example.hive.controllers;

import org.example.hive.helper.RegexHelper;
import org.example.hive.helper.WebHelper;
import org.example.hive.model.Admin;
import org.example.hive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminRestController {

    @Autowired
    WebHelper webHelper;

    @Autowired
    RegexHelper regexHelper;

    @Autowired
    AdminService adminService;

    @Value("#{servletContext.contextPath}")
    String contextPath;

    /** 작성 폼에 대한 action 페이지 */
    @RequestMapping(value = "/admin/join", method = RequestMethod.POST)
    public Map<String, Object> post(
            @RequestParam(value="password", required=false) String password,
            @RequestParam(value="email", required=false) String email,
            @RequestParam(value="name", required=false) String name,
            @RequestParam(value="contact", required=false) String contact,
            @RequestParam(value="department_cd", required=false) String department_cd) {

        /** 데이터 저장하기 */
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

        // 저장된 결과를 조회하기 위한 객체
        Admin output = null;

        try {
            // 데이터 저장
            // --> 데이터 저장에 성공하면 파라미터로 전달하는 input 객체에 PK값이 저장된다.
            adminService.addAdmin(input);

            // 데이터 조회
            output = adminService.getAdminItem(input);
        } catch (Exception e) {
            return webHelper.getJsonError(e.getLocalizedMessage());
        }

        /** 3) 결과를 확인하기 위한 JSON 출력 */
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("item", output);
        return webHelper.getJsonData(map);
    }
    
}
