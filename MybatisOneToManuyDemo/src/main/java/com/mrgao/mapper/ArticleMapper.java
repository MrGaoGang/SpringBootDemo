package com.mrgao.mapper;

import com.mrgao.enty.Article;

import java.util.List;

public interface ArticleMapper {

	/**
	 * 基本类型参数传递 只可传入一个
	 * @param userID
	 * @return
	 */
	public List<com.mrgao.enty.Article> getUserArticles(int userID);
}
