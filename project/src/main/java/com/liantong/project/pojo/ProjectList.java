package com.liantong.project.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class ProjectList {
	@ApiModelProperty(hidden = true)
	private long id;

	@ApiModelProperty(name = "projectName", value = "项目名称", required = true, dataType = "String", example = "项目名称")
	private String projectName;

	@ApiModelProperty(name = "regionId", value = "行政区ID", required = true, dataType = "String", example = "行政区ID")
	private String regionId;

	@ApiModelProperty(name = "industryId", value = "行业ID", required = true, dataType = "long", example = "1")
	private long industryId;//行业Id

	@ApiModelProperty(name = "projectStage", value = "项目阶段(0：商机；1：解决方案（可研）；2：招标；3：投标；4：实施；5：验收；6：维护)",allowableValues = "0, 1, 2, 3, 4, 5, 6", required = true, dataType = "int", example = "0")
	private  char projectStage;//0：商机；1：解决方案（可研）；2：招标；3：投标；4：实施；5：验收；6：维护

	@ApiModelProperty(name = "projectManageId", value = "项目经理", required = true, dataType = "long", example = "1")
	private long projectManageId;//项目经理

	@ApiModelProperty(name = "projectManagerPhone", value = "项目经理联系电话", required = true, dataType = "long", example = "1")
	private long projectManagerPhone;//项目经理联系电话

	@ApiModelProperty(name = "estimatedAmount", value = "预估金额", required = true, dataType = "Double", example = "1")
	private Double estimatedAmount;//预估金额

	@ApiModelProperty(name = "contractDate", value = "签订合同日期", required = true, dataType = "Date", example = "")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contractDate;//签订合同日期

	@ApiModelProperty(name = "contractAmount", value = "合同金额", required = true, dataType = "double", example = "1")
	private double contractAmount;//合同金额

	@ApiModelProperty(name = "intendedCompletionDate", value = "计划完成日期", required = true, dataType = "Date", example = "")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date intendedCompletionDate;//计划完成日期

	@ApiModelProperty(name = "contractPeriod", value = "合同日期", required = true, dataType = "String", example = "合同日期")
	private String contractPeriod;//合同日期

	@ApiModelProperty(name = "keywordIds", value = "关键词ids", required = true, dataType = "String", example = "1,2,3")
	private String keywordIds;//项目详情-描述

	@ApiModelProperty(hidden = true)
	private Date createTime;//创建时间
}
