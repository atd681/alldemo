package com.atd681.mybatis.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//
@RestController
public class DataController {

    // 注入DAO
    @Autowired
    private DataDAO dao;

    // 分别执行删除,插入,更新操作
    // 参数i: 插入时的字符串
    // 参数u: 更新时的字符串
    @GetMapping("/mybatis/test")
    @Transactional
    public String excuteSql(String i, String u) {

        // 删除数据后将参数i的内容插件数据库,将数据更新成参数u的内容
        // 该方法添加了事务,3次数据库操作会在同一个事务中执行.
        // Mybatis拦截器会捕获三次数据库SQL插入至数据库中(详见拦截器)
        dao.delete();
        dao.insert(i);
        dao.update(u);

        return "success";
    }

}
