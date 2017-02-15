package xin.fallen.dao;

import xin.fallen.bean.ItemSummary01;

public interface ItemSummary01Mapper {
    int deleteByPrimaryKey(String itemId);

    int insert(ItemSummary01 record);

    int insertSelective(ItemSummary01 record);

    ItemSummary01 selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(ItemSummary01 record);

    int updateByPrimaryKey(ItemSummary01 record);
}