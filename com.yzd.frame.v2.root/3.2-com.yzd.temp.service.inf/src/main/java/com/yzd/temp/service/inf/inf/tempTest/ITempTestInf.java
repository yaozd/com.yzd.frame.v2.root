package com.yzd.temp.service.inf.inf.tempTest;

import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;

/***
 * 实际的dubbo接口定义的地方
 */
public interface ITempTestInf {
    int insertSelective(TempTestDTO record);
}
