package com.yzd.temp.service.inf.dto.dtoExt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageWhereByMaxIdDTO implements Serializable {
    private int maxId;
    private int pageSize;
}