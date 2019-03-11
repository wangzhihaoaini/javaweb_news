package com.zr.news.service;

import com.zr.news.entity.News;
import com.zr.news.framework.JdbcDao;
import com.zr.news.framework.newsDao.NewsDao;
import com.zr.news.framework.newsDao.newsDaoImpl.NewsDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoService {
    private NewsDao newsDao=new NewsDaoImpl();

    public List<News> findImage() {
        String sql="SELECT * FROM news WHERE is_image=\"1\" ORDER BY publish_date DESC LIMIT 0,4;";
        List<News> list = new ArrayList<News>();
        Connection conn = JdbcDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int newsId = rs.getInt("news_id");
                String title = rs.getString("title");
                String imageUrl = rs.getString("image_url");
                News news = new News();
                news.setTitle(title);
                news.setImageUrl(imageUrl);
                news.setNewsId(newsId);
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcDao.closeConnection();
        }
        return list;
    }

    public List<News> findHeadNews(){
        String sql="SELECT * FROM news ORDER BY publish_date DESC LIMIT 0,1;";
        List<News> list = new ArrayList<News>();
        Connection conn = JdbcDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String title = rs.getString("title");
                String context = rs.getString("context");
                News news = new News();
                news.setTitle(title);
                news.setContext(context);
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcDao.closeConnection();
        }
        return list;
    }
}
