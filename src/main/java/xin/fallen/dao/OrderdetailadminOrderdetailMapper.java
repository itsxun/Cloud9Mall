package xin.fallen.dao;

import xin.fallen.bean.OrderdetailadminOrderdetail;

public interface OrderdetailadminOrderdetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderdetailadminOrderdetail record);

    int insertSelective(OrderdetailadminOrderdetail record);

    OrderdetailadminOrderdetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderdetailadminOrderdetail record);

    int updateByPrimaryKey(OrderdetailadminOrderdetail record);
}