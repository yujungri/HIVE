package org.example.hive.dao;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.example.hive.model.Admin;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/** Lombok의 log4j 객체 */
// import lombok.extern.slf4j.Slf4j;
@Slf4j
/** JUnit에 의한 테스트 클래스로 정의 */
// import org.junit.runner.RunWith;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
/**Spring의 설정 파일들을 읽어들이도록 설정 (**은 '모든' 이라는 의미) */
// import org.springframework.test.context.ContextConfiguration;
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/*-context.xml"})
/** 웹 어플리케이션임을 명시 */
// import org.springframework.test.context.web.WebAppConfiguration;
@WebAppConfiguration
/** 메서드 이름순서로 실행하도록 설정 (설정하지 않을 경우 무작위 순서로 실행됨) */
// import org.junit.FixMethodOrder;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminTest {
    /** MyBatis의 SQL세션 주입 설정 */
    // import org.springframework.beans.factory.annotation.Autowired;
    @Autowired
    private SqlSession sqlSession;

    /** 데이터 저장 테스트 */
    @Test
    public void testA() {
        Admin input = new Admin();
        input.setName("똘이");
        sqlSession.insert("AdminMapper.join", input);
    }


}
