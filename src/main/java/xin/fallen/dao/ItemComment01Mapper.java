package xin.fallen.dao;

import xin.fallen.bean.ItemComment01;

public interface ItemComment01Mapper {
    int deleteByPrimaryKey(String commentId);

    int insert(ItemComment01 record);

    int insertSelective(ItemComment01 record);

    ItemComment01 selectByPrimaryKey(String commentId);

    int updateByPrimaryKeySelective(ItemComment01 record);

    int updateByPrimaryKey(ItemComment01 record);
}