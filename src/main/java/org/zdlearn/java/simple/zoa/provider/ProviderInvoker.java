package org.zdlearn.java.simple.zoa.provider;

import io.netty.channel.Channel;
import org.zdlearn.java.simple.zoa.domain.ZOAContext;

import java.lang.reflect.Method;


/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.provider</p>
 * <p>类名称：  ProviderInvoker</p>
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
public class ProviderInvoker implements Invoker{
    private Server server;
    private Channel channel;
    public ProviderInvoker(Server server,Channel channel){
        this.server=server;
        this.channel=channel;
    }
    public void invoker(ZOAContext context) {
        try {
            Provider provider = server.getProvider(context.getInterfaceName());
            Method[] methods = provider.getRef().getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().equals(context.getMethodName())) {
                    Object result = method.invoke(provider.getRef(), context.getParams());
                    context.setResult(result);
                    channel.writeAndFlush(context);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            context.setResultCode("failded");
            channel.writeAndFlush(context);
        }
    }
}
