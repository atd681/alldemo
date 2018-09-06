package com.atd681.mybatis.stproxy;

public class Test {

    public static void main(String[] args) {

        // 需要谈判
        // 你找个律师代理你
        Person lawer = new Lawer(new You());

        // 开始谈判
        lawer.talk();

        // 需要签名
        lawer.sign();

    }

}
