package xin.fallen.dao;

import xin.fallen.bean.ItemSimpleMsg01;

public interface ItemSimpleMsg01Mapper {
    int deleteByPrimaryKey(Integer recordid);

    int insert(ItemSimpleMsg01 record);

    int insertSelective(ItemSimpleMsg01 record);

    ItemSimpleMsg01 selectByPrimaryKey(Integer recordid);

    int updateByPrimaryKeySelective(ItemSimpleMsg01 record);

    int updateByPrimaryKey(ItemSimpleMsg01 record);
}