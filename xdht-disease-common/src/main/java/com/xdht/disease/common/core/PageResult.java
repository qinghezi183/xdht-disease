package com.xdht.disease.common.core;

import lombok.Data;

import java.util.List;

/**
 * @author lzf
 **/
@Data
public class PageResult<E> {

    private Integer total;

    private List<E> dataList;

}
