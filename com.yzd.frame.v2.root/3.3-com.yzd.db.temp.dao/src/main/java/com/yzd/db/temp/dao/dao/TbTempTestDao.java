package com.yzd.db.temp.dao.dao;

import com.yzd.db.temp.dao.mapper.TbTempTestMapper;
import com.yzd.db.temp.entity.table.TbTempTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TbTempTestDao {
    @Autowired
    private TbTempTestMapper tbTempTestMapper;

    public int insertSelective(TbTempTest record){
        return tbTempTestMapper.insertSelective(record);
    }
}
