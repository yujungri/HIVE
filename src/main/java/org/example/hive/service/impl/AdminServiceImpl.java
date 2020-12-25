package org.example.hive.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.example.hive.model.Admin;
import org.example.hive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public Admin getAdminItem(Admin input) throws Exception {
        Admin result = null;

        try {
            result = sqlSession.selectOne("AdminMapper.selectItem", input);

            if (result == null) {
                throw new NullPointerException("result=null");
            }
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("조회된 데이터가 없습니다.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new Exception("데이터 조회에 실패했습니다.");
        }

        return result;
    }

    @Override
    public List<Admin> getAdminList(Admin input) throws Exception {
        return null;
    }

    @Override
    public int getAdminCount(Admin input) throws Exception {
        return 0;
    }

    /*회원가입 처리*/
    @Override
    public int addAdmin(Admin input) throws Exception {
        int result = 0;
        try {
            result = sqlSession.insert("AdminMapper.insertItem", input);

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

    @Override
    public int editAdmin(Admin input) throws Exception {
        return 0;
    }

    @Override
    public int deleteAdmin(Admin input) throws Exception {
        return 0;
    }
}
