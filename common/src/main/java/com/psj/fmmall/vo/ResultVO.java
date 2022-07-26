package com.psj.fmmall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author psj
 * @date 2022/7/16 23:02
 * @File: ResultVO.java
 * @Software: IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// swagger文档对返回对象的注释
@ApiModel(value = "ResultVO对象",description = "封装接口返回给前端的数据")
public class ResultVO {
    @ApiModelProperty(value = "响应状态码", dataType = "int")
    private int code;  // 响应给前端的状态码
    @ApiModelProperty(value = "响应提示信息", dataType = "string")
    private String msg;  // 响应给前端的提示信息
    @ApiModelProperty(value = "响应数据", dataType = "object")
    private Object data;  // 响应给前端的数据
}
