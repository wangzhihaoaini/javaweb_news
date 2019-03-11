package com.zr.news.framework.newsDao;

import com.zr.news.entity.NewsType;

import java.util.List;

public interface NewsTypeDao {
    List<NewsType> findAll();
}
