package com.yzd.temp.service.inf.inf.tempTest;

import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;

/***
 * 实际的dubbo接口定义的地方
 * 此接口的访问权限为default,只对本包可见
 * 不可使用public，防止接口适用。
 */
interface ITempTestInf {
    int insertSelective(TempTestDTO record);
}
