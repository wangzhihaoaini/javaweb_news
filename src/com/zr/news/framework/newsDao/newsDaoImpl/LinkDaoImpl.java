package com.zr.news.framework.newsDao.newsDaoImpl;

import com.zr.news.entity.Link;
import com.zr.news.framework.JdbcDao;
import com.zr.news.framework.newsDao.LinkDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinkDaoImpl implements LinkDao {

    @Override
    public List<Link> findAll() {
        String sql="SELECT * FROM link ORDER BY link_order";
        List<Link> list = new ArrayList<>();
        Connection conn = JdbcDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int linkId=rs.getInt("link_id");
                String linkName=rs.getString("link_name");
                String email=rs.getString("email");
                String linkUrl=rs.getString("link_url");
                int linkOrder=rs.getInt("link_order");
                Link link = new Link(linkId,linkName,email,linkUrl,linkOrder);
                list.add(link);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcDao.closeConnection();
        }
        return list;
    }
}
