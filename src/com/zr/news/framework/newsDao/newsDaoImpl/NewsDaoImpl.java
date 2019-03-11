package com.zr.news.framework.newsDao.newsDaoImpl;

import com.zr.news.entity.News;
import com.zr.news.framework.JdbcDao;
import com.zr.news.framework.newsDao.NewsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    @Override
    public List<News> findAll() {
        String sql="SELECT * FROM news";
        List<News> list = new ArrayList<>();
        Connection conn = JdbcDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int newsId=rs.getInt("link_id");
                String title=rs.getString("link_name");
                String context=rs.getString("email");
                String author=rs.getString("link_url");
                int typeId=rs.getInt("link_order");
                Date date=rs.getDate("publish_date");
                int isImage=rs.getInt("is_image");
                String imageUrl=rs.getString("image_url");
                int click=rs.getInt("click");
                int isHot=rs.getInt("is_hot");
                News news = new News(newsId,title,context,author,typeId,date,isImage,imageUrl,click,isHot);
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcDao.closeConnection();
        }
        return list;
    }

    public List<News> findImage() {
        String sql="SELECT * FROM news WHERE is_image=\"1\" ORDER BY publish_date DESC LIMIT 0,4;";
        List<News> list = new ArrayList<News>();
        Connection conn = JdbcDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String title = rs.getString("title");
                String image_url = rs.getString("image_url");
                News news = new News();
                news.setTitle(title);
                news.setImageUrl(image_url);
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
