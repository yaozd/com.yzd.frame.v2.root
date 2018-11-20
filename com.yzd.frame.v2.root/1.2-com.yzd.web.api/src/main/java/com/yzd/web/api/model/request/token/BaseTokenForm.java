package com.yzd.web.api.model.request.token;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class BaseTokenForm {
    /***
     * 请求时间戳
     */
    @NotBlank
    @Pattern(regexp = "[\\d]{13}")
    private String timestamp;
}