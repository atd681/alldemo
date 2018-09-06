package com.atd681.mybatis.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 动态代理类
// 需要实现InvocationHandler接口的invoke方法
public class PersonProxy implements InvocationHandler {

    // 当调用被代理的接口的任何方法时都会执行到该方法中
    // proxy: 被调用的委托者对象
    // method: 委托者被调用的方法对象
    // args: 委托者被调用的的方法的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        return null;
    }

}
