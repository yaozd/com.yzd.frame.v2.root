package com.yzd.web.service;

import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;
import com.yzd.temp.service.inf.inf.tempTest.ITempTestInfForFront;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempTestService {

    @Autowired
    ITempTestInfForFront iTempTestInfForFront;

    public int save(TempTestDTO record){
        return iTempTestInfForFront.insertSelective(record);
    }
}
