package com.atd681.mybatis.interceptor;

import org.springframework.stereotype.Repository;

// 数据DAO
@Repository
public interface DataDAO {

    // 添加数据
    void insert(String dv);

    // 更新数据
    void update(String dv);

    // 删除数据
    void delete();

}
