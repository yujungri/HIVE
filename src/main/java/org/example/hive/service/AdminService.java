package org.example.hive.service;
import org.example.hive.model.Admin;

import java.util.List;

public interface AdminService {
    /**
     * Admin 데이터 상세 조회
     * @param input 조회할 사용자의 일련번호를 담고 있는 Beans
     * @return 조회된 데이터가 저장된 Beans
     * @throws Exception
     */
    public Admin getAdminItem(Admin input) throws Exception;

    /**
     * Admin 데이터 목록 조회
     * @return 조회 결과에 대한 컬렉션
     * @throws Exception
     */
    public List<Admin> getAdminList(Admin input) throws Exception;

    /**
     * Admin 데이터가 저장되어 있는 갯수 조회
     * @return int
     * @throws Exception
     */
    public int getAdminCount(Admin input) throws Exception;

    /**
     * Admin 데이터 등록하기
     * @param input 저장할 정보를 담고 있는 Beans
     * @return int
     * @throws Exception
     */
    public int addAdmin(Admin input) throws Exception;

    /**
     * Admin 데이터 수정하기
     * @param input 수정할 정보를 담고 있는 Beans
     * @return int
     * @throws Exception
     */
    public int editAdmin(Admin input) throws Exception;

    /**
     * Admin 데이터 삭제하기
     * @param input 삭제할 정보를 담고 있는 Beans
     * @return int
     * @throws Exception
     */

    public int deleteAdmin(Admin input) throws Exception;
}
