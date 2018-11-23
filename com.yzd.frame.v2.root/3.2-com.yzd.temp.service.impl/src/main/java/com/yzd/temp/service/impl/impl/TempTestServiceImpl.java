package com.yzd.temp.service.impl.impl;

import com.yzd.db.temp.dao.dao.TbTempTestDao;
import com.yzd.db.temp.entity.TbTempTest;
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
        TbTempTest record= TempTestConverter.toEntity(data);
        int result= tbTempTestDao.insertSelective(record);
        return result;
    }
}
