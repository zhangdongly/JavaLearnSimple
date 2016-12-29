package org.zdlearn.java.simple.zoa.provider;

import org.zdlearn.java.simple.zoa.api.HellowordApi;
import org.zdlearn.java.simple.zoa.api.HellowordApiImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.provider</p>
 * <p>类名称：  Server</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  wyzhangdong</p>
 * <p>创建日期：2016/12/29 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author wyzhangdong</p>
 * <p>@see</p>
 */
public class Server {

    Map<String,Provider> providerMap;

    public Provider getProvider(String className){
        return providerMap.get(className);
    }

    public void run(){
        initProvider();
            ZOAServer zoaServer=new ZOAServer("localhost",9500,this);
        zoaServer.run();
    }

    private void initProvider(){
        //这里只有一个提供者类，就直接放入吧
        HellowordApi hellowordApi=new HellowordApiImpl();
        String name=hellowordApi.getClass().getInterfaces()[0].getCanonicalName();
        providerMap=new HashMap<String, Provider>();
        providerMap.put(name,new Provider(name,hellowordApi));
    }

    public static void main(String [] args){
        new Server().run();
    }

}
