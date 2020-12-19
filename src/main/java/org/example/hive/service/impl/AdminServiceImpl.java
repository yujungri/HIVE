package org.example.hive.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.hive.model.Admin;
import org.example.hive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SqlSession sqlSession;


    /*회원가입 처리*/
    @Override
    public int signUp(Admin input) throws Exception {
        int result = 0;
        try {
            result = sqlSession.insert("AdminMapper.signUp", input);

            if (result == 0) {
                throw new NullPointerException("result=0");
            }
        } catch (NullPointerException e) {
            throw new Exception("저장된 데이터가 없습니다.");
        } catch (Exception e) {
            throw new Exception("데이터 저장에 실패했습니다.");
        }

        return result;

    }
}
