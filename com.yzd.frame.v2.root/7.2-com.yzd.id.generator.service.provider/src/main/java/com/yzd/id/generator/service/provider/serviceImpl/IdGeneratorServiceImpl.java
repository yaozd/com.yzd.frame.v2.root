package com.yzd.id.generator.service.provider.serviceImpl;

import com.yzd.id.generator.service.inf.IIdGeneratorServiceInf;
import com.yzd.id.generator.service.provider.inf.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zd.yao on 2017/3/30.
 */
@Service
public class IdGeneratorServiceImpl implements IIdGeneratorServiceInf {

    @Autowired
    IdGenerator idGenerator;

    @Override
    public Number generateId() {
        return idGenerator.generateId();
    }
}