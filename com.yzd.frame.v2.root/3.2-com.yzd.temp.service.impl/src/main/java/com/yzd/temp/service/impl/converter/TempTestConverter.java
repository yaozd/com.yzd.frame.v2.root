package com.yzd.temp.service.impl.converter;

import com.yzd.db.temp.entity.table.TbTempTest;
import com.yzd.temp.service.inf.bo.tempTest.TempTestBO;
import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;

import java.util.Date;

/***
 * 数据转换器
 */
public class TempTestConverter {
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

    /***
     * 将数据库的实体对象--转化为响应输出对象
     * @param data
     * @return
     */
    public static TempTestBO toBO(TbTempTest data){
        TempTestBO bo=new TempTestBO();
        bo.setValue("临时测试数据");
        return bo;
    }
}
