package com.liantong.keyword.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class KeywordVo {

	@ApiModelProperty(hidden = true)
	private long id;

	@ApiModelProperty(name = "name", value = "关键词名称", required = true, dataType = "String", example = "项目名称")
	private String name;
}
