package com.liantong.industry.service;

import com.liantong.industry.pojo.Industry;
import com.liantong.industry.pojo.IndustryVo;

import java.util.List;

public interface IndustryService {
	void createIndustry(Industry industry)throws Exception;

	List<IndustryVo> selectIndustry()throws Exception;

	List<IndustryVo> selectDisableIndustry()throws Exception;

	void deleteIndustry(Long industryId)throws Exception;

	void enableIndustry(Long industryId)throws Exception;

	void updateIndustry(Long industryId,String name)throws Exception;
}
