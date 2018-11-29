package com.yzd.id.generator.service.provider.impl;

import com.yzd.id.generator.service.inf.IIdGeneratorServiceInf;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zd.yao on 2017/3/30.
 */
@Slf4j
public class IdGeneratorService_UnitTest extends _BaseUnitTest {

    @Autowired
    private IIdGeneratorServiceInf idGeneratorServiceInf;

    @Test
    public void generateId() {
        Number id = idGeneratorServiceInf.generateId();
        log.info(id.toString());
        assertThat(id).isNotEqualTo(null);
    }
}
