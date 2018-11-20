package com.yzd.web.api.model.request.token;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RefreshTokenFrom extends BaseTokenForm{
    @NotBlank
    private String appId;
    @NotBlank
    private String appTypeId;
    @NotBlank
    private String refreshToken;
}