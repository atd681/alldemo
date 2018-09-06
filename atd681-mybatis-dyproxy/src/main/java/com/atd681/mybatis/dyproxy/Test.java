package com.atd681.mybatis.dyproxy;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        // 动态代理类
        PersonProxy proxy = new PersonProxy();

        // 调用动态代理类的newProxyInstance可获取, newProxyInstance参数如下:
        // 参数1: 生成代理类的类加载器
        // 参数2: 代理的接口, JAVA根据接口在生成的代理类中自动添加接口的实现方法(执行参数3的invoke)
        // 参数3: 实现InvocationHandler的代理类对象, 当调用参数2接口中的方法时会执行该类的invoke方法
        Person person = (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[] { Person.class }, proxy);

        // 调用接口的方法, 会自动执行到动态代理类的invoke中
        person.talk();
        person.sign();

    }

}
