package xin.fallen.dao;

import xin.fallen.po.HefengCityCode;

public interface HefengCityCodeMapper {
    int deleteByPrimaryKey(String id);

    int insert(HefengCityCode record);

    int insertSelective(HefengCityCode record);

    HefengCityCode selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HefengCityCode record);

    int updateByPrimaryKey(HefengCityCode record);

    String selectPrimaryKeyByCityName(String cityName);
}