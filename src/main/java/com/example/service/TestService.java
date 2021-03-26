package com.example.service;

import com.example.domain.Consumer;
import com.example.domain.QueryVo;

import java.util.List;

/**
 * @author xy
 */
public interface TestService {
    void insert(Consumer consumer);

    List<Consumer> search(QueryVo queryVo);
}
