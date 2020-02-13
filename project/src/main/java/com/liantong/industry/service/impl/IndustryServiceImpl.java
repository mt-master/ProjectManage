package com.liantong.industry.service.impl;

import com.liantong.industry.mapper.IndustryMapper;
import com.liantong.industry.pojo.Industry;
import com.liantong.industry.pojo.IndustryVo;
import com.liantong.industry.service.IndustryService;
import com.liantong.sys.util.IdWorker;
import com.liantong.sys.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	IndustryMapper industryMapper;

	@Override
	public void createIndustry(Industry industry) throws Exception{
		industry.setId(IdWorker.nextId());
		industry.setCreateBy(UserUtil.getUser().getId());
		industry.setCreateTime(new Date());
		industry.setStatusFlag('0');
		industryMapper.createIndustry(industry);
	}

	@Override
	public List<IndustryVo> selectIndustry() throws Exception {
		return industryMapper.selectIndustry('0');////0为启用
	}

	@Override
	public List<IndustryVo> selectDisableIndustry() throws Exception {
		return industryMapper.selectIndustry('1');//1为禁用
	}

	@Override
	public void deleteIndustry(Long industryId)throws Exception{
		industryMapper.deleteIndustry(industryId,'1');//1为禁用
	}

	@Override
	public void enableIndustry(Long industryId) throws Exception {
		industryMapper.deleteIndustry(industryId,'0');//0为启用
	}

	@Override
	public void updateIndustry(Long industryId,String name)throws Exception {
		Industry industry = new Industry();
		industry.setId(industryId);
		industry.setName(name);
		industry.setUpdateBy(UserUtil.getUser().getId());
		industry.setUpdateTime(new Date());
		industryMapper.updateIndustry(industry);//0为启用
	}
}
