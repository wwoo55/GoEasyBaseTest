package com.example.dao;


import com.example.domain.Consumer;
import com.example.domain.QueryVo;

import java.util.List;

public interface TestDao {

    void insert(Consumer consumer);

    List<Consumer> query(QueryVo queryVo);
}
