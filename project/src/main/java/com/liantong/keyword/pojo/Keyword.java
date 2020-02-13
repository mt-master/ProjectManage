package com.liantong.keyword.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class Keyword {

	@ApiModelProperty(hidden = true)
	private long id;

	@ApiModelProperty(name = "name", value = "关键词名称", required = true, dataType = "String", example = "关键词名称")
	private String name;

	@ApiModelProperty(hidden = true)
	private Date createTime;

	@ApiModelProperty(hidden = true)
	private long createBy;

	@ApiModelProperty(hidden = true)
	private Date updateTime;

	@ApiModelProperty(hidden = true)
	private long updateBy;

	@ApiModelProperty(hidden = true)
	private char statusFlag;
}
