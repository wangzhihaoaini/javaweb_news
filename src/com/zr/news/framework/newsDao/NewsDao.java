package com.zr.news.framework.newsDao;

import com.zr.news.entity.News;

import java.util.List;

public interface NewsDao {
    List<News> findAll();
}
