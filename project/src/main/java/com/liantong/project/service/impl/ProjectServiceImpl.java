package com.liantong.project.service.impl;

import com.liantong.keyword.mapper.KeywordMapper;
import com.liantong.project.mapper.ProjectMapper;
import com.liantong.project.pojo.Project;
import com.liantong.project.pojo.ProjectKeywordRelation;
import com.liantong.project.service.ProjectService;
import com.liantong.sys.util.IdSequence;
import com.liantong.sys.util.IdWorker;
import com.liantong.sys.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectMapper projectMapper;

	@Autowired
	KeywordMapper keywordMapper;

	@Override
	public void createProject(Project project) throws Exception {
		Long id = IdWorker.nextId();
		project.setId(id);
		project.setCreateBy(UserUtil.getUser().getId());
		project.setCreateTime(new Date());
		project.setStatusFlag('0');
		projectMapper.createProject(project);

		List<Long> keywordsList = keywordMapper.selectKeywordIdByKeyword(project.getKeywordIds());
		List<ProjectKeywordRelation> list= new ArrayList<>();
		if(keywordsList!=null){
			for (Long keywordId:keywordsList){
				ProjectKeywordRelation pkr = new ProjectKeywordRelation();
				pkr.setId(IdWorker.nextId());
				pkr.setKeywordId(keywordId);
				pkr.setProjectId(id);
				list.add(pkr);
			}
			projectMapper.insertProjectKeywordRel(list);
		}
	}

}
