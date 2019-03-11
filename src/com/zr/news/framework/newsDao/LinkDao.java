package com.zr.news.framework.newsDao;

import com.zr.news.entity.Link;

import java.util.List;

public interface LinkDao {
    List<Link> findAll();
}
