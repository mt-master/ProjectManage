package com.liantong.project.mapper;

import com.liantong.project.pojo.Project;
import com.liantong.project.pojo.ProjectKeywordRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface ProjectMapper {

	/**
	 * 新增项目
	 * @param project
	 */
	void createProject(Project project);

	/**
	 * 批量新增项目和关键词的关联
	 * @param List
	 */
	void insertProjectKeywordRel(List<ProjectKeywordRelation> list);
}
