package xin.fallen.dao;

import xin.fallen.bean.OrderadminOrder;

public interface OrderadminOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderadminOrder record);

    int insertSelective(OrderadminOrder record);

    OrderadminOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderadminOrder record);

    int updateByPrimaryKey(OrderadminOrder record);
}