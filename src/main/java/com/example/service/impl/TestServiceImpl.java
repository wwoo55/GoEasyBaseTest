package com.example.service.impl;

import com.example.dao.TestDao;
import com.example.dao.impl.TestDaoImpl;
import com.example.domain.Consumer;
import com.example.domain.QueryVo;
import com.example.service.TestService;

import java.util.List;

/**
 * @projectName: demo_xy
 * @className: TestServiceImpl
 * @description:
 * @author: xy
 * @time: 2021/3/26 14:21
 */
public class TestServiceImpl implements TestService {

    /**
     * 调用dao中的insert
     * @param consumer
     */
    @Override
    public void insert(Consumer consumer) {
        TestDao testDao = new TestDaoImpl();
        testDao.insert(consumer);
    }

    /**
     * 调用dao中的search
     * @param queryVo
     * @return
     */
    @Override
    public List<Consumer> search(QueryVo queryVo) {
        TestDao testDao = new TestDaoImpl();
        return testDao.query(queryVo);
    }


}
