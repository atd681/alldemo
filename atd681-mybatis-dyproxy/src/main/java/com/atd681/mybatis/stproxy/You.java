package com.atd681.mybatis.stproxy;

// 你
public class You implements Person{

    // 你的谈判
    @Override
    public void talk() {
        System.out.println("你开始谈判");
    }

    // 你的签名
    @Override
    public void sign() {
        System.out.println("你开始签名");
    }

}
