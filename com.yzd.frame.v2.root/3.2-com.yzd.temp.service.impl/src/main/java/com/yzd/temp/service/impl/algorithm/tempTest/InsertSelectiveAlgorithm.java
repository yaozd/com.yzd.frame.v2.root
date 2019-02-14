package com.yzd.temp.service.impl.algorithm.tempTest;

import com.yzd.db.temp.entity.table.TbTempTest;
import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;

import java.util.Date;

/***
 * 为每一个类中的方法定义一个算法类
 * 用于集中处理方法中设计的数据转换与数据判断等操作
 * 保证方法中代码的整洁性。
 */
public class InsertSelectiveAlgorithm {
    /***
     * 将请求的输入对象--转化为数据库的实体对象
     * @param data
     * @return
     */
    public static TbTempTest toEntity(TempTestDTO data){
        TbTempTest entity =new TbTempTest();
        entity.setName(data.getName());
        entity.setPassword(data.getPassword());
        entity.setGmtCreate(new Date());
        entity.setGmtModified(new Date());
        entity.setGmtIsDeleted(1);
        return entity;
    }
}
