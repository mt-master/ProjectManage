package com.liantong.organization.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationVo {

	private String id;

	private String name;

	private String parentId;

	private String regionId;

	private char isParent;
}
