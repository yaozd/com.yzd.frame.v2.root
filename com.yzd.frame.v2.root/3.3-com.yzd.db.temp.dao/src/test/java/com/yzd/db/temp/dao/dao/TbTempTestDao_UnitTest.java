package com.yzd.db.temp.dao.dao;

import com.yzd.db.temp.dao.dao.base._BaseUnitTest;
import com.yzd.db.temp.entity.table.TbTempTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TbTempTestDao_UnitTest extends _BaseUnitTest {

    @Autowired
    private TbTempTestDao tbTempTestDao;
    @Test
    public void insertSelective() {
        TbTempTest item=new TbTempTest();
        item.setName("xxx");
        tbTempTestDao.insertSelective(item);
    }
}