package org.zdlearn.java.simple.zoa;

import org.zdlearn.java.simple.zoa.consumer.ZOAClient;
import org.zdlearn.java.simple.zoa.domain.ZOAContext;
import org.zdlearn.java.simple.zoa.api.HellowordApi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.domain</p>
 * <p>类名称：  RpcInvoker</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  wyzhangdong</p>
 * <p>创建日期：2016/12/28 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author wyzhangdong</p>
 * <p>@see</p>
 */
public class RpcInvoker implements InvocationHandler {
    public <T> T bindWithNoImplementation(Class<T> t) {
        /**
         * 因为传入参数t未实现，所以没有classLoader。所以不能用
         * t.getClass().getClassLoader()。这个时候时候直接用默认的
         * loader即可。
         */
        return (T) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), new Class[]{t}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //根据返回参数做特殊处理
        System.out.println(method.getGenericReturnType());
        ZOAContext context=new ZOAContext();
        context.setInterfaceName(method.getDeclaringClass().getName());
        context.setMethodName(method.getName());
        context.setParams(args);
        new ZOAClient("localhost",9500,context).run();
        return null;
    }

    public static void main(String [] args){
        HellowordApi api=new RpcInvoker().bindWithNoImplementation(HellowordApi.class);
        api.helloWord("AAAA");
    }
}
