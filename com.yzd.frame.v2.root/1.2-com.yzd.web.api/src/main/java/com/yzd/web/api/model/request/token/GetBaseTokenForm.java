package com.yzd.web.api.model.request.token;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GetBaseTokenForm extends BaseTokenForm {
    /***
     * AppId最好是唯一的值UUID或者是设备号
     */
    @NotBlank
    private String appId;
    /***
     * AppTypeId类型=web(1),android(2),ios(3)
     */
    @NotBlank
    private String appTypeId;
}
