package com.zr.news.service;

import com.zr.news.entity.NewsType;
import com.zr.news.framework.newsDao.NewsTypeDao;
import com.zr.news.framework.newsDao.newsDaoImpl.NewsTypeDaoImpl;

import java.util.List;

public class NewsTypeService {
    private NewsTypeDao newsTypeDao=new NewsTypeDaoImpl();
    public List<NewsType> findAll(){
        List<NewsType> list = newsTypeDao.findAll();
        return list;
    }
}
