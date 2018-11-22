package com.yzd.temp.service.inf.dto.tempTest;

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
    @NotNull
    private String password;

}
