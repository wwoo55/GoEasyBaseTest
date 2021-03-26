package com.example.dao.impl;

import com.example.dao.TestDao;
import com.example.domain.Consumer;
import com.example.domain.QueryVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: demo_xy
 * @className: TestDaoImpl
 * @description:
 * @author: xy
 * @time: 2021/3/26 17:04
 */
public class TestDaoImpl implements TestDao {
    /**
     * 数据库添加
     * @param consumer
     */
    @Override
    public void insert(Consumer consumer) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
            pst = conn.prepareStatement("insert into consumer(name,sex,birthdate,tel,job,note) values (?,?,?,?,?,?)");
            pst.setString(1, consumer.getName());
            pst.setInt(2, consumer.getSex());
            pst.setDate(3, new java.sql.Date(consumer.getBirthdate().getTime()));
            pst.setString(4, consumer.getTel());
            pst.setString(5, consumer.getJob());
            pst.setString(6, consumer.getNote());
            pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    /**
     * 数据库查询
     * @param queryVo
     * @return
     */
    @Override
    public List<Consumer> query(QueryVo queryVo) {
        List<Consumer> consumers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
            // 拼接动态sql语句
            StringBuilder sbStr = new StringBuilder();
            sbStr.append("select * from consumer where 1=1 ");
            if (queryVo.getName() != null) {
                sbStr.append(" and name = ? ");
            }
            if (queryVo.getSex() != null) {
                sbStr.append(" and sex = ? ");
            }
            if (queryVo.getBirthdate() != null) {
                sbStr.append(" and birthdate = ? ");
            }
            String sql = sbStr.toString();
            pst = conn.prepareStatement(sql);
            int count = 1;
            if (queryVo.getName() != null) {
                pst.setString(count, queryVo.getName());
                count++;
            }
            if (queryVo.getSex() != null) {
                pst.setInt(count, queryVo.getSex());
                count++;
            }
            if (queryVo.getBirthdate() != null) {
                pst.setDate(count, new java.sql.Date(queryVo.getBirthdate().getTime()));
            }
            rs = pst.executeQuery();

            // 解析返回结果并封装
            while (rs.next()) {
                Consumer consumer = new Consumer();
                consumer.setId(rs.getLong("id"));
                consumer.setName(rs.getString("name"));
                consumer.setSex(rs.getInt("sex"));
                consumer.setBirthdate(rs.getDate("birthdate"));
                consumer.setTel(rs.getString("tel"));
                consumer.setJob(rs.getString("job"));
                consumer.setNote(rs.getString("note"));
                consumers.add(consumer);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return consumers;
    }
}
