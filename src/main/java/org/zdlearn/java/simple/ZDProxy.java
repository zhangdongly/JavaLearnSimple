package org.zdlearn.java.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wyzhangdong on 2016/12/5.
 * Java原生的代理
 */
public class ZDProxy implements InvocationHandler {



    public <T> T bindWithNoImplementation(Class<T> t) {
        /**
         * 因为传入参数t未实现，所以没有classLoader。所以不能用
         * t.getClass().getClassLoader()。这个时候时候直接用默认的
         * loader即可。
         */
        return (T) Proxy.newProxyInstance(
               ClassLoader.getSystemClassLoader(), new Class[]{t}, this);
    }

    public <T> T bindWithImplementation(Class<T> t) {
        /**
         * 因为传入参数t未实现，所以没有classLoader。所以不能用
         * t.getClass().getClassLoader()。这个时候时候直接用默认的
         * loader即可。
         */
        return (T) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), t.getInterfaces(), this);
    }



    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //根据返回参数做特殊处理
        System.out.println(method.getGenericReturnType());
        return null;
    }





}
