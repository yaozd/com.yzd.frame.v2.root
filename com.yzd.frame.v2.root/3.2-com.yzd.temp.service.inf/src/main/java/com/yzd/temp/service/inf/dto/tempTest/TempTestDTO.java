package com.yzd.temp.service.inf.dto.tempTest;

import com.yzd.logging.sensitive.SensitiveLogInfo;
import com.yzd.logging.sensitive.SensitiveLogType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * 输入对象
 * Created by zd.yao on 2017/3/22.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TempTestDTO implements Serializable {
    @NotNull
    private String name;
    //对用户的敏感信息在打印日志的时候进行脱敏处理
    @SensitiveLogInfo(type = SensitiveLogType.PASSWORD)
    @NotNull
    private String password;

}
