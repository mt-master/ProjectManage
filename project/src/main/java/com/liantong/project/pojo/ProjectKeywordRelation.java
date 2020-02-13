package com.liantong.project.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectKeywordRelation {

	private Long id;

	private Long projectId;

	private Long keywordId;
}
