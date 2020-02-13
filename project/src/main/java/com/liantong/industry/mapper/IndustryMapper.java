package com.liantong.industry.mapper;

import com.liantong.industry.pojo.Industry;
import com.liantong.industry.pojo.IndustryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndustryMapper {
	void createIndustry(Industry industry);

	List<IndustryVo> selectIndustry(@Param("statusFlag")char statusFlag);

	/**
	 * 禁用启用行业
	 * 1：禁用，0：启用
	 * @param industryId
	 * @param statusFlag
	 */
	void deleteIndustry(@Param("industryId")Long industryId,@Param("statusFlag")char statusFlag);

	/**
	 * 修改行业名称
	 * @param industryId
	 * @param name
	 */
	void updateIndustry(Industry industry);
}
