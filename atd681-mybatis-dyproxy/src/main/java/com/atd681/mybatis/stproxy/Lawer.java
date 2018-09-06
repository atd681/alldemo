package com.atd681.mybatis.stproxy;

// 律师
public class Lawer implements Person {

    // 委托人(被代理人)
    private Person client;

    // 创建律师时必须指定委托人
    public Lawer(Person client) {
        this.client = client;
    }

    // 律师的谈判
    @Override
    public void talk() {

        // 谈判不需要委托人出面, 由律师完成
        // 因此不需要调用委托人的talk方法
        System.out.println("律师开始谈判");

    }

    // 律师的签名
    @Override
    public void sign() {

        // 律师不能代替委托人签名
        // 需要调用委托人的sign方法
        client.sign();

    }

}
