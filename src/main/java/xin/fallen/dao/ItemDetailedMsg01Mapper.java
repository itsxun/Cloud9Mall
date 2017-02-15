package xin.fallen.dao;

import xin.fallen.bean.ItemDetailedMsg01;

public interface ItemDetailedMsg01Mapper {
    int deleteByPrimaryKey(String itemId);

    int insert(ItemDetailedMsg01 record);

    int insertSelective(ItemDetailedMsg01 record);

    ItemDetailedMsg01 selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(ItemDetailedMsg01 record);

    int updateByPrimaryKey(ItemDetailedMsg01 record);
}