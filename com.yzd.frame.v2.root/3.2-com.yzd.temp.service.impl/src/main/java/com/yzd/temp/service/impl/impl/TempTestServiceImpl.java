package com.yzd.temp.service.impl.impl;

import com.yzd.db.temp.entity.TbTempTest;
import com.yzd.temp.service.impl.converter.TempTestConverter;
import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;
import com.yzd.temp.service.inf.inf.tempTest.ITempTestInfForBack;
import com.yzd.temp.service.inf.inf.tempTest.ITempTestInfForFront;

public class TempTestServiceImpl implements ITempTestInfForFront,ITempTestInfForBack {

    @Override
    public int insertSelective(TempTestDTO data) {
        TbTempTest record= TempTestConverter.toEntity(data);
        return 0;
    }
}
