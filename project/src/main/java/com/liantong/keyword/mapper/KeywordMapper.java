package com.liantong.keyword.mapper;

import com.liantong.keyword.pojo.Keyword;
import com.liantong.keyword.pojo.KeywordVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeywordMapper {
	void createKeyword(Keyword keyword);

	List<KeywordVo> selectKeyword(@Param("statusFlag") char statusFlag);

	/**
	 * 禁用启用关键词
	 * 1：禁用，0：启用
	 * @param keywordId
	 * @param statusFlag
	 */
	void deleteKeyword(@Param("keywordId") Long keywordId, @Param("statusFlag") char statusFlag);

	void updateKeyword(Keyword keyword);

	/**
	 * 根据keywordIds查询keywordId列表
	 * @param keywordIds
	 * @return
	 */
	List<Long> selectKeywordIdByKeyword(@Param("keywordIds") String keywordIds);

	boolean selectKeywordByName(@Param("name") String name);
}
