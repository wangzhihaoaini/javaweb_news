<%@ page import="com.zr.news.service.LinkDaoService" %>
<%@ page import="com.zr.news.entity.Link" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
        <div class="col-md-12">
            <div class="link ">
                <div class="linkHeader ">友情链接</div>
                <div class="datas">
                    <ul>
                        <%
                            LinkDaoService linkDaoService = new LinkDaoService();
                            List<Link> linkList = linkDaoService.findLink();
                            for (Link link:linkList) {
                        %>
                        <li>
                            <a href="<%=link.getLinkUrl()%>" target="_blank "><%=link.getLinkName()%></a>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </div>
</div>
