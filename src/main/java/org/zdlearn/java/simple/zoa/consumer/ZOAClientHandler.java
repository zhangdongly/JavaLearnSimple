package org.zdlearn.java.simple.zoa.consumer;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.zdlearn.java.simple.zoa.domain.ZOAContext;

/**
 * Created by wyzhangdong on 2016/12/23.
 */
public class ZOAClientHandler extends ChannelInboundHandlerAdapter {

    private ZOAContext context;

    public ZOAClientHandler(){}

    public ZOAClientHandler(ZOAContext context){
       this.context=context;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // Send the message to Server
        super.channelActive(ctx);
        ctx.writeAndFlush(context);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        ZOAContext context=(ZOAContext) msg;

      System.out.println("调用结果为："+((ZOAContext) msg).getResult());
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
