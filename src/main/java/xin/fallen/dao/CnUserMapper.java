package xin.fallen.dao;

import xin.fallen.bean.CnUser;

public interface CnUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CnUser record);

    int insertSelective(CnUser record);

    CnUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CnUser record);

    int updateByPrimaryKey(CnUser record);

    Integer selectEmailIfExist(String email);

    String selectUsernameIfExist(String email);

    Integer selectPrimaryKeyForLogin(String username, String password);

}