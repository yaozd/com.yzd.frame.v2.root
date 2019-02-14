package com.yzd.web.api.controllerApi;

import com.yzd.temp.service.inf.dto.tempTest.TempTestDTO;
import com.yzd.web.api.model.response._base.*;
import com.yzd.web.api.model.response.temp.TempTestVM;
import com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID.MutexKeyForAccessUUID;
import com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID.MutexLockByAccessUUID;
import com.yzd.web.api.utils.preconditionsExt.PreconditionsUtil;
import com.yzd.web.service.service.TempTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        TempTestDTO tempTestDTO = new TempTestDTO();
        tempTestDTO.setName("my");
        tempTestDTO.setPassword("123456");
        //Integer result = tempTestService.save(new TempTestDTO());
        Integer result = tempTestService.save(tempTestDTO);
        log.info("result={}", result);
        //return new JsonResultOk("result="+result);
        return JsonResultOk.SUCCESS;

    }

    /**
     * 参数有数据性验证
     *
     * @return
     */
    @GetMapping("dataValidTest")
    public JsonResult dataValidTest() {
        // 数据校验
        // 方法一：可提高代码的可读性
        PreconditionsUtil.checkDataThrowException(1 != 2, "异常提示信息：1!=2");
        // 方法二：
        if (1 != 2) {
            throw JsonResultError.newDataValidException("1!=2");
        }
        //
        return JsonResultOk.SUCCESS;
    }

    /**
     * Swagger-响应泛型数据结果
     *
     * @return
     */
    @GetMapping("getTempTest")
    public JsonResultData<TempTestVM> getTempTest() {
        TempTestVM tempTestVM = new TempTestVM();
        tempTestVM.setName("name");
        return JsonResultData.build(tempTestVM);
    }

    /***
     * Swagger-响应泛型数据结果
     * @return
     */
    @GetMapping("getTempTestList")
    public JsonResultList<TempTestVM> getTempTestList() {
        TempTestVM tempTestVM = new TempTestVM();
        tempTestVM.setName("name");
        List<TempTestVM> tempTestVMList = new ArrayList<>();
        tempTestVMList.add(tempTestVM);
        return JsonResultList.build(tempTestVMList);
    }
}
