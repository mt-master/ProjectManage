package com.liantong.sys.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class User implements Serializable {

	@ApiModelProperty(hidden = false)
	private long id;

	@ApiModelProperty(name = "mss", value = "mss工号", required = true, dataType = "String", example = "liantong1")
	private String mss;

	@ApiModelProperty(name = "password", value = "密码", required = true, dataType = "String", example = "123456")
	private String password;

	@ApiModelProperty(name = "realName", value = "真实姓名", required = true, dataType = "String", example = "联通")
	private String realName;

	@ApiModelProperty(name = "organizationId", value = "所属组织机构Id", required = true, dataType = "String", example = "1213651276961677312")
	private long organizationId;

	@ApiModelProperty(name = "sex", value = "性别：0：男，1：女", required = true,dataType = "int", allowableValues = "0, 1", example = "0")
	private int sex;

	@ApiModelProperty(name = "phone", value = "联系电话", required = true,dataType = "String", example = "18000000000")
	private String phone;

	@ApiModelProperty(name = "email", value = "邮箱", required = false,dataType = "String", example = "18000000000@unicom.cn")
	private String email;

	@ApiModelProperty(hidden = false)
	private Timestamp createTime;

	@ApiModelProperty(hidden = false)
	private int createBy;

	@ApiModelProperty(hidden = false)
	private Timestamp updateTime;

	@ApiModelProperty(hidden = false)
	private String updateBy;

	@ApiModelProperty(hidden = false)
	private String imageUrl;

	@ApiModelProperty(hidden = false)
	private String statusFlag;

	@ApiModelProperty(hidden = false)
	private int sort;

	@ApiModelProperty(hidden = false)
	private Set<Role> roles = new HashSet<>();

}