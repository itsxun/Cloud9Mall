package xin.fallen.dao;

import org.apache.ibatis.annotations.Param;
import xin.fallen.bean.CnUser;

public interface CnUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CnUser record);

    int insertSelective(CnUser record);

    CnUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CnUser record);

    int updateByPrimaryKey(CnUser record);

    Integer selectPrimaryKeyForLogin(@Param("username") String username, @Param("password") String password);

    Integer selectEmailIfExist(String email);
}