package xin.fallen.dao;

import xin.fallen.bean.ShopadminCnshop;

public interface ShopadminCnshopMapper {
    int deleteByPrimaryKey(String shopId);

    int insert(ShopadminCnshop record);

    int insertSelective(ShopadminCnshop record);

    ShopadminCnshop selectByPrimaryKey(String shopId);

    int updateByPrimaryKeySelective(ShopadminCnshop record);

    int updateByPrimaryKey(ShopadminCnshop record);
}