package xin.fallen.dao;

import xin.fallen.bean.CnShop;

public interface CnShopMapper {
    int deleteByPrimaryKey(String shopId);

    int insert(CnShop record);

    int insertSelective(CnShop record);

    CnShop selectByPrimaryKey(String shopId);

    int updateByPrimaryKeySelective(CnShop record);

    int updateByPrimaryKey(CnShop record);
}