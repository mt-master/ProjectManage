package com.liantong.organization.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class Organization {

	@ApiModelProperty(hidden = true)
	private long id;

	@ApiModelProperty(name = "name", value = "组织机构名称", required = true, dataType = "String", example = "省集成BU")
	private String name;

	@ApiModelProperty(name = "parentId", value = "所属组织机构父节点ID", required = true, dataType = "long", example = "1213651276961677312")
	private long parentId;

	@ApiModelProperty(name = "regionId", value = "所属行政区ID", required = true, dataType = "String", example = "35")
	private String regionId;

	@ApiModelProperty(hidden = true)
	private char isParent;

	@ApiModelProperty(hidden = true)
	private String parentCode;

	@ApiModelProperty(hidden = true)
	private int code;

	@ApiModelProperty(hidden = true)
	private Date createTime;

	@ApiModelProperty(hidden = true)
	private long createBy;

	@ApiModelProperty(hidden = true)
	private Date updateTime;

	@ApiModelProperty(hidden = true)
	private long updateBy;
}
