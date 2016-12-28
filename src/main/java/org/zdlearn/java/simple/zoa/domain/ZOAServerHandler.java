package org.zdlearn.java.simple.zoa.domain;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;

/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.domain</p>
 * <p>类名称：  ZOAServerHandler</p>
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
public class ZOAServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        ZOAContext context =(ZOAContext)msg;
        Object in=Class.forName(context.getInterfaceName()).newInstance();
        Method[] methods=Class.forName(context.getInterfaceName()).getMethods();
        for(Method method:methods){
            if(method.getName().equals(context.getMethodName())){
              Object result = method.invoke(in,"zoa");
                context.setResultJson(String.valueOf(result));
            }
        }
        ctx.writeAndFlush(context);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}