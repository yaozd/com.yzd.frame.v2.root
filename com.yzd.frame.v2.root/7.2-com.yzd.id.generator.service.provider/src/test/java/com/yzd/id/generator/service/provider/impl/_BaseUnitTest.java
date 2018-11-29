package com.yzd.id.generator.service.provider.impl;


import com.yzd.id.generator.service.provider.startup.ApplicationIdGeneratorServiceConsumer;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zd.yao on 2017/3/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationIdGeneratorServiceConsumer.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class _BaseUnitTest {
}

