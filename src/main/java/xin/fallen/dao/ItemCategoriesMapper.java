package xin.fallen.dao;

import xin.fallen.bean.ItemCategories;

public interface ItemCategoriesMapper {
    int insert(ItemCategories record);

    int insertSelective(ItemCategories record);
}