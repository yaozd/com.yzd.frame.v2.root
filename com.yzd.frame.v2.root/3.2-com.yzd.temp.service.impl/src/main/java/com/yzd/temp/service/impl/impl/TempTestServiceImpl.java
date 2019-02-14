package com.yzd.temp.service.impl.impl;

import com.yzd.db.temp.dao.dao.TbTempTestDao;
import com.yzd.db.temp.entity.table.TbTempTest;
import com.yzd.temp.service.impl.algorithm.tempTest.InsertSelectiveAlgorithm;
import com.yzd.temp.service.impl.converter.TempTestConverter;
import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;
import com.yzd.temp.service.inf.inf.tempTest.ITempTestInfForBack;
import com.yzd.temp.service.inf.inf.tempTest.ITempTestInfForFront;
import org.springframework.beans.factory.annotation.Autowired;

public class TempTestServiceImpl implements ITempTestInfForFront,ITempTestInfForBack {

    @Autowired
    private TbTempTestDao tbTempTestDao;

    @Override
    public int insertSelective(TempTestDTO data) {
        //方法一：
        //TbTempTest record= InsertSelectiveAlgorithm.toEntity(data);
        //方法二：
        TbTempTest record= TempTestConverter.toEntity(data);
        int result= tbTempTestDao.insertSelective(record);
        return result;
    }
}
