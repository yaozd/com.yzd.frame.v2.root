package com.yzd.temp.service.inf.dto.dtoExt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageWhereDTO implements Serializable {
    private int begin;
    private int pageIndex;
    private int pageSize;
    private String orderBy;
}