package com.liantong.organization.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionVo {
	private String id;

	private String name;

	private String parentId;

	private char isParent;
}
