package com.zr.news.framework.newsDao.newsDaoImpl;

import com.zr.news.entity.NewsType;
import com.zr.news.framework.JdbcDao;
import com.zr.news.framework.newsDao.NewsTypeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsTypeDaoImpl implements NewsTypeDao {
    @Override
    public List<NewsType> findAll() {
        String sql="SELECT * FROM news_type";
        List<NewsType> list = new ArrayList<NewsType>();
        Connection conn = JdbcDao.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int typeId = rs.getInt("type_id");
                String typeName = rs.getString("type_name");
                NewsType newsType = new NewsType();
                newsType.setTypeId(typeId);
                newsType.setTypeName(typeName);
                list.add(newsType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcDao.closeConnection();
        }
        return list;
    }
}
