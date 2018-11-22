package com.yzd.temp.service.inf.bo.tempTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * 输出对象
 * Created by zd.yao on 2017/3/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TempTestBO implements Serializable {

    private String value;
}
