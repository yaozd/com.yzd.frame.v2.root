package com.yzd.db.temp.dao.mapper;

import com.yzd.db.temp.entity.table.TbTempTest;

public interface TbTempTestMapper {
    int insert(TbTempTest record);

    int insertSelective(TbTempTest record);

    TbTempTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbTempTest record);

    int updateByPrimaryKey(TbTempTest record);
}