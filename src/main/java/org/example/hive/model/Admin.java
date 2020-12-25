package org.example.hive.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
public class Admin {
    private int idx;
    private String password;
    private String email;
    private String name;
    private String contact;
    private String department_cd;
    private String department_nm;
    private String token;
    private Date join_at;
    private Date login_at;
}
