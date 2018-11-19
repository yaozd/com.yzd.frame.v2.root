package com.yzd.web.api.model.request.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class LoginForm {
    @NotBlank
    private String name;
    @NotBlank
    private String passworld;

}