package com.yzd.web.api.controllerApi;

import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;
import com.yzd.web.api.model.response._base.JsonResult;
import com.yzd.web.api.model.response._base.JsonResultOk;
import com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID.MutexKeyForAccessUUID;
import com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID.MutexLockByAccessUUID;
import com.yzd.web.service.TempTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("${appPath}/api/temp")
public class TempControllerAPI {

    @Autowired
    TempTestService tempTestService;

    @GetMapping("save")
    //通过Token中访问UUID值的互斥锁（顺序执行锁），作用：保证同一操作的顺序执行
    @MutexLockByAccessUUID(key = MutexKeyForAccessUUID.SaveTemptestLock)
    public JsonResult save() {
        TempTestDTO tempTestDTO=new TempTestDTO();
        tempTestDTO.setName("my");
        tempTestDTO.setPassword("123456");
        //Integer result = tempTestService.save(new TempTestDTO());
        Integer result = tempTestService.save(tempTestDTO);
        log.info("result={}", result);
        return new JsonResultOk("result="+result);

    }
}
