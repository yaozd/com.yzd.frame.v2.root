package com.yzd.web.api.model.request.account;

import com.yzd.logging.sensitive.SensitiveLogInfo;
import com.yzd.logging.sensitive.SensitiveLogType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class LoginForm {
    @NotBlank
    private String name;
    //对用户的敏感信息在打印日志的时候进行脱敏处理
    @SensitiveLogInfo(type = SensitiveLogType.PASSWORD)
    @NotBlank
    private String passworld;

}