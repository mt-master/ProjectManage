package com.liantong.keyword.service;

import com.liantong.keyword.pojo.Keyword;
import com.liantong.keyword.pojo.KeywordVo;

import java.util.List;

public interface KeywordService {
	void createKeyword(Keyword keyword)throws Exception;

	List<KeywordVo> selectKeyword()throws Exception;

	List<KeywordVo> selectDisableKeyword()throws Exception;

	void deleteKeyword(Long keywordId)throws Exception;

	void enableKeyword(Long keywordId)throws Exception;

	void updateKeyword(Long keywordId,String name)throws Exception;
}
