package com.zr.news.service;

import com.zr.news.entity.Link;
import com.zr.news.framework.JdbcDao;
import com.zr.news.framework.newsDao.LinkDao;
import com.zr.news.framework.newsDao.newsDaoImpl.LinkDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinkDaoService {
    private LinkDao linkDao=new LinkDaoImpl();
    public List<Link> findAll(){
        return linkDao.findAll();
    }

    public List<Link> findLink(){
        String sql="SELECT * FROM link";
        List<Link> list = new ArrayList<>();
        Connection conn = JdbcDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String linkName=rs.getString("link_name");
                String linkUrl=rs.getString("link_url");
                Link link = new Link();
                link.setLinkName(linkName);
                link.setLinkUrl(linkUrl);
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
