package com.liantong.keyword.service.impl;

import com.liantong.keyword.mapper.KeywordMapper;
import com.liantong.keyword.pojo.Keyword;
import com.liantong.keyword.pojo.KeywordVo;
import com.liantong.keyword.service.KeywordService;
import com.liantong.sys.util.IdWorker;
import com.liantong.sys.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Autowired
	KeywordMapper keywordMapper;

	@Override
	public void createKeyword(Keyword keyword)throws Exception{
		if(keywordMapper.selectKeywordByName(keyword.getName())){
			throw new Exception("名称重复");
		}
		keyword.setId(IdWorker.nextId());
		keyword.setCreateBy(UserUtil.getUser().getId());
		keyword.setCreateTime(new Date());
		keyword.setStatusFlag('0');
		keywordMapper.createKeyword(keyword);
	}

	@Override
	public List<KeywordVo> selectKeyword()throws Exception {
		return keywordMapper.selectKeyword('0');////0为启用
	}

	@Override
	public List<KeywordVo> selectDisableKeyword()throws Exception {
		return keywordMapper.selectKeyword('1');//1为禁用
	}

	@Override
	public void deleteKeyword(Long keywordId)throws Exception {
		keywordMapper.deleteKeyword(keywordId,'1');//1为禁用
	}

	@Override
	public void enableKeyword(Long keywordId)throws Exception {
		keywordMapper.deleteKeyword(keywordId,'0');//0为启用
	}

	@Override
	public void updateKeyword(Long keywordId,String name)throws Exception {
		Keyword keyword = new Keyword();
		keyword.setId(keywordId);
		keyword.setName(name);
		keyword.setUpdateBy(UserUtil.getUser().getId());
		keyword.setUpdateTime(new Date());
		keywordMapper.updateKeyword(keyword);//0为启用
	}
}
