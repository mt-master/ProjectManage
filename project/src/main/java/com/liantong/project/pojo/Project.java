package com.liantong.project.pojo;

import com.liantong.keyword.pojo.KeywordVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class Project {
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

	@ApiModelProperty(name = "projectInfo", value = "项目详情-描述", required = true, dataType = "String", example = "项目详情-描述")
	private String projectInfo;//项目详情-描述

	@ApiModelProperty(name = "assignableProjectScore", value = "可分配的项目积分", required = true, dataType = "int", example = "1")
	private int assignableProjectScore;//可分配的项目积分

	@ApiModelProperty(name = "keywordIds", value = "关键词ids", required = true, dataType = "String", example = "1,2,3")
	private String keywordIds;//项目详情-描述

	@ApiModelProperty(hidden = true)
	private Date createTime;//创建时间

	@ApiModelProperty(hidden = true)
	private long createBy;//创建人

	@ApiModelProperty(hidden = true)
	private Date updateTime;//更新时间

	@ApiModelProperty(hidden = true)
	private long updateBy;//更新人

	@ApiModelProperty(hidden = true)
	private char statusFlag;//0：正常 1：禁用
}
