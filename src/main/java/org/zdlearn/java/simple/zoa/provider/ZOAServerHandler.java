package org.zdlearn.java.simple.zoa.provider;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.zdlearn.java.simple.zoa.domain.ZOAContext;

/**
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.domain</p>
 * <p>类名称：  ZOAServerHandler</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  zhangdong147896325@163.com</p>
 * <p>创建日期：2016/12/28 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author zhangdong147896325@163.com</p>
 * <p>@see</p>
 */
public class ZOAServerHandler extends ChannelInboundHandlerAdapter {

    private Server server;

    public ZOAServerHandler(Server server){
        this.server=server;
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ZOAContext context =(ZOAContext)msg;
        //直接执行
        ProviderInvoker providerInvoker=new ProviderInvoker(server,ctx.channel());
        providerInvoker.invoker(context);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
